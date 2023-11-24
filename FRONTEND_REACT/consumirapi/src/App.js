import React from 'react';
import './assets/css/App.css';
//Mandamos a llamar a la librería que descargamos en Boostrap
import "bootstrap/dist/css/bootstrap.css"; 
// Importamos la libreria de ROuter
import { BrowserRouter as Router , Routes , Route} from 'react-router-dom'
// Importamos el Login
import Login from './components/Login';
// Impotamos componente Dashboard
import Dashboard from './components/Dashboard';
import Editar from './components/Editar';
import Nuevo from './components/Nuevo';
import Register from './components/Register';
import TipoUsuarioSelection from './components/TipoUsuarioSelection';
import RegisterForm from './components/RegisterForm';
import RegistrationPage from './components/RegistrationPage';
import UserTypeSelection from './components/UserTypeSelection';
import Index_Dueno from './components/Index_Dueno';
import Index_Paseador from './components/Index_Paseador';

function App() {
  return (
    //Usamos la etiqueta propia de React
    <React.Fragment>
      <Router>
        <Routes>
           <Route path='/login' element={<Login />} />
           <Route path='/' element={<Dashboard />} />
           <Route path='/editar' element={<Editar />} />
           <Route path='/nuevo' element={<Nuevo />} />
           <Route path='/register' element={<Register />} />
           <Route path='/tipousuarioselection' element={<TipoUsuarioSelection />} />
           <Route path='/usertypeselection' element={<UserTypeSelection />} />
           <Route path='/registerform' element={<RegisterForm />} />
           <Route path='/registrationpage' element={<RegistrationPage />} />
           <Route path='/index_dueno' element={<Index_Dueno />} />
           <Route path='/index_paseador' element={<Index_Paseador />} />
        </Routes>
      </Router>
    </React.Fragment>
  );
}

export default App;
