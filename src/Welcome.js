import React from 'react';
import './Welcome.css';

export default function Welcome() {
  return (
    <div className='welcomeImage'>
      <div className='overlay'></div>
      <div className='content'>
        <h1>Welcome to My Blog Post</h1>
        <p>share your thought with us</p>
      </div>
    </div>
  );
}
