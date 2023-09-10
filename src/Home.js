import React from 'react';
import './Home.css';
import { Link, Route, Routes, useNavigate } from 'react-router-dom';
import Community from './Community';
import Post from './Post';
import Welcome from './Welcome';

export default function Home() {
  const nav = useNavigate()
  return (
    <div>
      <div className='homecontroller'>
      <div className='homecontrollercommunity' onClick={()=>nav('post')}>post
        </div>
        <div className="homecontrollercenterline"> </div>
        <div className='homecontrollercommunity' onClick={()=>nav('community')}>
          community
        </div>
      </div>
      <div className='homeomponents'>
        <Routes>
          
        <Route index path='/*' element={<Welcome />}  />
          <Route path='community/*' element={<Community />} />
          <Route path='post/*' element={<Post />} />
          
        </Routes>
       
      </div>
    </div>
  );
}
