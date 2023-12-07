import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom'; // Importa useHistory desde react-router-dom
import axios from 'axios';
// Initialization for ES Users
import { Input, Ripple, initMDB } from "mdb-ui-kit";
import { Link } from "react-router-dom";  
import logo from '../assets/css/img/Logo.jpeg';
initMDB({ Input, Ripple });


function Register() {
  const navigate = useNavigate(); // Obtiene la instancia de history
  const [formData, setFormData] = useState({
    nombres: '',
    apellidos: '',
    apodo: '',
    direccion: '',
    edad: '',
    celular: '',
    dni: '',
    email: '',
    password: '',
    tipoUsuarioId: localStorage.getItem('selectedType'), // Obtiene el tipo de usuario seleccionado de LocalStorage
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) =>{
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/api/v1/auth/register', formData);
      console.log('Respuesta del servidor:', response.data);
      if (response.status === 200){
        navigate('/login');
      }
    } catch (error) {
      console.error('Error al enviar datos:', error);
      // Manejo de las Excepciones
    }
  };

  return (

    /* CREACION DEL NAVBAR */
    <React.Fragment>
    <nav class="navbar navbar-expand navbar-dark bg-dark">
    <div class="container-fluid">
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <Link class="navbar-brand" to="/">
   
        <img src={logo} id="icon" alt="User Icon" class="logo-img rounded-pill" />
      </Link>
      <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item px-3">
            <Link to="/usertypeselection" class="nav-link active">Registrarme</Link>
          </li>
          <li class="nav-item px-3">
            <Link to="/login" class="nav-link active">Iniciar Sesión</Link>
          </li>
          <li class="nav-item px-3">
            <Link to="/login" class="nav-link active">Acerca de</Link>
          </li>
          <li class="nav-item px-3">
            <Link to="/login" class="nav-link active">Servicios</Link>
          </li>
        </ul>
        <form class="d-flex">
          <input class="form-control me-2" type="search" placeholder="Busca lo que necesitas !" aria-label="Search" />
          <button class="btn btn-outline-success" type="submit">Buscar</button>
        </form>
      </div>
    </div>
  </nav>
 
    {/* CREACION DEL REGISTRO */}
    <div class="container bg-body-secondary py-5">
          <form onSubmit={handleSubmit}>
              <div class="row bg offset-md-4">
                  <div class=" col-md-3">
                        <div data-mdb-input-init class="form-outline ">
                            <label class="form-label" for="form3Example1">Nombres</label>
                            <input type="text" id="form3Example1" class="form-control" name="nombres" onChange={handleChange}/>   
                        </div>
                  </div>
                  <div class="col-md-3">
                        <div data-mdb-input-init class="form-outline">
                            <label class="form-label" for="form3Example2">Apellidos</label>
                            <input type="text" id="form3Example2" class="form-control" name="apellidos" onChange={handleChange}/>                            
                        </div>
                  </div>
              </div>

              <div class="row bg offset-md-4">
                    <div class="col-md-3">
                        <div data-mdb-input-init class="form-outline">
                            <label class="form-label" for="form3Example3">Edad</label>
                            <input type="number" id="form3Example3" class="form-control" name="edad" onChange={handleChange}/>                          
                        </div>
                    </div>    
                    <div class="col-md-3">
                        <div data-mdb-input-init class="form-outline">
                            <label class="form-label" for="form3Example4">Email</label>
                            <input type="email" id="form3Example4" class="form-control" name="email" onChange={handleChange}/>   
                        </div>
                    </div>
              </div>

              <div class="row bg offset-md-4">
                    <div class="col-md-3">
                        <div data-mdb-input-init class="form-outline ">
                            <label class="form-label" for="form3Example5">Apodo</label>
                            <input type="text" id="form3Example5" class="form-control" name="apodo" onChange={handleChange}/>     
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div data-mdb-input-init class="form-outline">
                            <label class="form-label" for="form3Example6">Direccion</label>
                            <input type="text" id="form3Example6" class="form-control" name="direccion" onChange={handleChange}/>     
                        </div>
                    </div>
              </div>

              <div class="row bg offset-md-4">
                    <div class="col-md-3">
                        <div data-mdb-input-init class="form-outline">
                            <label class="form-label" for="form3Example7">Celular</label>
                            <input type="number" id="form3Example7" class="form-control" name="celular" onChange={handleChange}/>  
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div data-mdb-input-init class="form-outline"> 
                            <label class="form-label" for="form3Example8">Dni</label>
                            <input type="number" id="form3Example8" class="form-control" name="dni" onChange={handleChange}/>    
                        </div>
                    </div>
              </div>
              <div class="row offset-md-5 mt-2">
                        <div data-mdb-input-init class="form-outline col-md-4 ">
                            <label class="form-label text-center" for="form3Example9">Password</label>
                            <input type="password" id="form3Example9" class="form-control" name="password" onChange={handleChange}/>
                        </div> 
              </div>
              <button type="submit" class="btn btn-success btn-block mt-3 offset-md-5 col-md-2" >
                  Sign up
              </button>        
        </form>
    </div>
    </React.Fragment>
  );
}

export default Register;
