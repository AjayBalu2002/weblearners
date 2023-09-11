import axios from 'axios';
import { Box, Button, Card, Collapse, Input, Modal, ThemeIcon } from '@mantine/core';
import './Communitystyle.css'
import React, { useEffect, useState } from 'react';
import { useDisclosure } from '@mantine/hooks';

export default function Community() {
  const [posts, setPosts] = useState([]);
  const [openedPosts, setOpenedPosts] = useState([]);
  const [usernames, setUsernames] = useState({});
  const [opened, { open, close }] = useDisclosure(false);
  const [openupdatemodel,setopenupdatemodel] = useState(false);
  const [postupdate,setPostUpdate] = useState('')
  const [currentpostid,setpostid] = useState(0)
  const [currentcommentid,setcommentid] = useState(0)
  const [eachcomment,seteachcomment] = useState('')
const [commentupdate,setCommentUpdate] = useState('')

  const fetchPosts = () => {
    axios
      .get('http://localhost:5000/posts', {
        headers: {
          Authorization: `Bearer ${localStorage.getItem('token')}`,
        },
      })
      .then((res) => {
        setPosts(res.data);
        console.log(res.data)
        
        setOpenedPosts(new Array(res.data.length).fill(false));
      })
      .catch((error) => {
        console.log(error);
      });
  };

  useEffect(() => {
    
    fetchPosts();
  }, []);





function handlepostupdate(post,postid)
{
  setPostUpdate(post)
  setpostid(postid)
  open()
}




useEffect(() => {
  // Fetch usernames for all user IDs
  const userIds = posts.map(post => post.userId);
  userIds.forEach(userId => {
    axios.post(`http://localhost:5000/users/getusername/${userId}`, {}, {
      headers: {
        Authorization: `Bearer ${localStorage.getItem('token')}`,
      },
    })
    .then(res => {
      setUsernames(prevUsernames => ({
        ...prevUsernames,
        [userId]: res.data,
      }));
    })
    .catch(error => {
      console.log(error);
    });
  });
}, [posts]);


  function handleCollapse(indx) {
    
    const newOpenedPosts = [...openedPosts];
    newOpenedPosts[indx] = !newOpenedPosts[indx];
    setOpenedPosts(newOpenedPosts);
    
  }

function handlesubmitpost()
{
  if(postupdate!='')
  {
 const tempupdatepost =  {
    postId:0,
  userId: 1,
  post: postupdate,
  comments: [
    
  ]
}

axios.put(`http://localhost:5000/posts/${currentpostid}`, tempupdatepost, {
  headers: {
    Authorization: `Bearer ${localStorage.getItem('token')}`,
  },
})
.then((res) => {
  console.log(res);
  fetchPosts(); 
  close(); 
})
.catch(error => {
  console.log(error);
});



fetchPosts();
close()
  

}
}

function handleremovepost(postId)
{


  axios.delete(`http://localhost:5000/posts/${postId}`, {
    headers: {
      Authorization: `Bearer ${localStorage.getItem('token')}`,
    },
  })
  .then(res => fetchPosts())
  .catch(error => {
    console.log(error);
  })
  
}



function posteachcomment(postId)
{
  if(eachcomment!='')
  {

  
const tempcomment = {
  commentId:0,
  commentatorId:localStorage.getItem('userId'),
  comment:eachcomment
}

  axios.post(`http://localhost:5000/posts/${postId}/comments`,tempcomment, {
    headers: {
      Authorization: `Bearer ${localStorage.getItem('token')}`,
    },
  })
  .then(res => fetchPosts())
  .catch(error => {
    console.log(error);
  })

seteachcomment('')
  }
}

function handlesubmitComment()
{
  if(commentupdate!='')
  {

  
  const tempcomment = {
    
    commentatorId:parseInt(localStorage.getItem('userId')),
    comment:commentupdate
  }
  console.log(tempcomment)

  axios.put(`http://localhost:5000/comments/${currentcommentid}`, tempcomment, {
    headers: {
      Authorization: `Bearer ${localStorage.getItem('token')}`,
    },
  })
  .then((res) => {
    console.log(res);
    fetchPosts(); 
    setopenupdatemodel(false)
  })
  .catch(error => {
    console.log(error);
  });
  
  }

}

function opentheupdatemodel(comment,commentId)
{

  setopenupdatemodel(true)
setcommentid(commentId)
setCommentUpdate(comment)
}

function handleremovecomment(commentId)
{
  axios.delete(`http://localhost:5000/comments/${commentId}`, {
    headers: {
      Authorization: `Bearer ${localStorage.getItem('token')}`,
    },
  })
  .then(res => fetchPosts())
  .catch(error => {
    console.log(error);
  })
}


  return (
    <div className='totalcommunity'>
      <div className='allposts'>
        {posts.map((e, indx) => (
          <div key={indx}>
            <h5 className='commusername'>{usernames[e.userId]}</h5>
            {localStorage.getItem('userId')==e.userId?  (<div><Button id='coombtn' className='commedit' onClick={()=>handlepostupdate(e.post,e.postId)} >edit</Button>
            <Button className='commdelete' id='coombtn' onClick={()=>handleremovepost(e.postId)} >delete</Button></div>):null}
          
            <Card shadow="sm" padding="lg" className='eachpost' radius="md" withBorder>
              <q>{e.post}</q>
            </Card>
            <Box>
              <Button   id='coombtn' onClick={() => handleCollapse(indx)} className='comments'>
                comments
              </Button>
            </Box>
            <Collapse in={openedPosts[indx]}>
                 {e.comments.map(ele => <div className='commentsfunction'>
                  <h6 className='commentatorid' >{usernames[ele.commentatorId]}</h6>
                  <p className='commentquotation'>{ele.comment}</p>

                  {localStorage.getItem('userId')==ele.commentatorId ?(<div>
                   
                  <Button className='commentbuttons1' id='coombtn' onClick={()=>opentheupdatemodel(ele.comment,ele.commentId)}>edit</Button>
                  <Button  className='commentbuttons'  id='coombtn' onClick={()=>handleremovecomment(ele.commentId)} >delete</Button></div>):null}




                 </div>      )}
                 <Input value={eachcomment}  className='commentinput' onChange={(e)=>seteachcomment(e.target.value)}></Input>

                 <Button onClick={()=>posteachcomment(e.postId)}  id='coombtn' >post</Button>
            </Collapse>
          </div>

        ))
        }
         <Modal opened={opened} onClose={close} title="edit the post">
      

        <Input value={postupdate} onChange={(e)=>setPostUpdate(e.target.value)}></Input>
        <Button onClick={()=>handlesubmitpost()}  id='coombtn' >ok</Button>
      </Modal>

      <Modal opened={openupdatemodel} onClose={()=>setopenupdatemodel(false)} title="edit the comment">
       

        <Input value={commentupdate} onChange={(e)=>setCommentUpdate(e.target.value)}></Input>
        <Button onClick={()=>handlesubmitComment()}  id='coombtn' >ok</Button>
      </Modal>
      </div>
    </div>
  );
}
