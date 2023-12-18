import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import api from '../api';

const LoginPage = () => {
  const [credentials, setCredentials] = useState({ nombre_usuario: '', contraseña: '' });
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await api.login(credentials);
      navigate('/menu');
    } catch (error) {
      console.error('Error de login:', error);
    }
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setCredentials({ ...credentials, [name]: value });
  };

  return (
    <div className="container d-flex justify-content-center align-items-center vh-100" style={{
      background: '#1D976C',
      background: '-webkit-linear-gradient(to right, #93F9B9, #1D976C)', 
      background: 'linear-gradient(to right, #93F9B9, #1D976C)' 
    }}>
      <div className="card p-4">
        <h2 className="mb-4">Login</h2>
        <div className="row">
          <div className="col-md-6">
            <form onSubmit={handleSubmit}>
              <div className="mb-3">
                <label htmlFor="nombre_usuario" className="form-label">Nombre de Usuario:</label>
                <input
                  type="text"
                  className="form-control"
                  id="nombre_usuario"
                  name="nombre_usuario"
                  value={credentials.nombre_usuario}
                  onChange={handleInputChange}
                  required
                />
              </div>

              <div className="mb-3">
                <label htmlFor="contraseña" className="form-label">Contraseña:</label>
                <input
                  type="password"
                  className="form-control"
                  id="contraseña"
                  name="contraseña"
                  value={credentials.contraseña}
                  onChange={handleInputChange}
                  required
                />
              </div>

              <button type="submit" className="btn btn-primary">Iniciar sesión</button>
            </form>
          </div>
          <div className="col-md-6 d-flex justify-content-center align-items-center text-center">
            <img
              src="https://i.pinimg.com/736x/13/9b/7c/139b7cbc98f23755be8825c3ff4c9aea.jpg"
              alt="Imagen"
              className="img-fluid"
            />
          </div>
        </div>
      </div>
    </div>
  );
};

export default LoginPage;
