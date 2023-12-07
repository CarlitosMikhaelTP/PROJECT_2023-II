import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import { Link } from "react-router-dom";
import iconoWsp from '../assets/css/img/iconoWsp.png';
import logo from '../assets/css/img/Logo.jpeg';
import paseador from '../assets/css/img/paseador.jpg';
import propietario from '../assets/css/img/Propietario.jpg';


const UserTypeSelection = () => {
  const navigate = useNavigate();
  const [selectedType, setSelectedType] = useState(null);

  const handleTypeSelection = (typeId) => {
    // Almacena el tipo de usuario seleccionado
    localStorage.setItem('selectedType', typeId);

    // Redirige a la página de registro
    navigate('/register');
  };

  return (
    <React.Fragment>
      {/* NAVBAR DEL INDEX */}
      <nav className="navbar navbar-expand navbar-dark bg-dark">
        <div className="container-fluid">
          <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <Link className="navbar-brand" to="/">
            {/* Cambié logo por la variable que contiene el logo */}
            <img src={logo} id="icon" alt="User Icon" className="logo-img rounded-pill" />
          </Link>
          <div className="collapse navbar-collapse" id="navbarTogglerDemo03">
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              <li className="nav-item px-3">
                <Link to="/usertypeselection" className="nav-link active">Registrarme</Link>
              </li>
              <li className="nav-item px-3">
                <Link to="/login" className="nav-link active">Iniciar Sesión</Link>
              </li>
              <li className="nav-item px-3">
                <Link to="/login" className="nav-link active">Acerca de</Link>
              </li>
              <li className="nav-item px-3">
                <Link to="/login" className="nav-link active">Servicios</Link>
              </li>
            </ul>
            <form className="d-flex">
              <input className="form-control me-2" type="search" placeholder="Busca lo que necesitas !" aria-label="Search" />
              <button className="btn btn-outline-success" type="submit">Buscar</button>
            </form>
          </div>
        </div>
      </nav>
      {/* Construccion de los botones para seleccionar el tipo de usuario */}
      <div className="container-fluid bg-light ">
    <div className="row align-self-center py-3 rounded-4 text-center">
        <div className="h2 mx-5 bg-body-secondary text-bg-light py-2">
            Selecciona el tipo de usuario al que quieres pertenecer
        </div>
        <div className="col-md-6 py-3 bg-black">
            <button onClick={() => handleTypeSelection(1)}>
                <img src={propietario} alt="" className="w-75 rounded-4"/>
            </button>
        </div>
        <div className="col-md-6 py-3 bg-black">
            <button onClick={() => handleTypeSelection(2)}>
                <img src={paseador} alt="" className="w-75 rounded-4"/>
            </button>
        </div>
    </div>
</div>


    </React.Fragment>
  );
};

export default UserTypeSelection;
