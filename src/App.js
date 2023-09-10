import './App.css';
import Loginpage from './Loginpage';
import Registrationpage from './Registrationpage';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './Home';
import Welcome from './Welcome';

function App() {
  return (
    <div className="App">

        <Routes>
          <Route index path='/' element={<Loginpage />} />
         
          <Route path='/home/*' element={<Home/>}  />
          <Route path='/register' element={<Registrationpage />} />
        </Routes>

    </div>
  );
}

export default App;
