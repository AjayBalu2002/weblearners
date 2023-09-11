import React, { useState } from 'react';
import './Post.css';
import { useNavigate } from 'react-router-dom';
import { Button, CheckIcon, Input, Notification } from '@mantine/core';
import axios from 'axios';

export default function Post() {
  const nav = useNavigate();
  const [inptvalue, setinptvalue] = useState('');
  const [showNotification, setShowNotification] = useState(false);

  function handleinput(e) {
    setinptvalue(e.target.value);
  }

  function handlesubmit() {
    if(inptvalue!='')
    {

    
    const temphobj = {
      postId: 0,
      userId: localStorage.getItem('userId'),
      post: inptvalue,
      comments: [],
    };

    axios
      .post('http://localhost:5000/posts', temphobj, {
        headers: {
          Authorization: `Bearer ${localStorage.getItem('token')}`,
        },
      })
      .then((res) => {
        console.log(res);
        setinptvalue('');
        setShowNotification(true);
        setTimeout(() => {
          setShowNotification(false)
        }, 1000);
        // localStorage.setItem('userId', res.data.id);
        // localStorage.setItem('userName', res.data.name);
        // nav('/home');
      })
      .catch((error) => {
        console.log(error);
      });
    }
  }

  return (
    <div className='posttotal'>

{showNotification && (
          <Notification
            icon={<CheckIcon size='1.1rem' />}
            color='teal'
            title=''
            className='notification'
            
          >
            your post is uploaded successfully
          </Notification>
        )}
      <div className='inputcontainer'>

    


        <input
          className='post'
          value={inptvalue}
          onChange={(e) => handleinput(e)}
        ></input>

        <Button className='postsubmit' onClick={handlesubmit}>
          Submit
        </Button>

        
      </div>
    </div>
  );
}
