import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';  

import api from '../api';

const RegistroPage = () => {
  const navigate = useNavigate();  

  const [formData, setFormData] = useState({
    nombres: '',
    apellidos: '',
    nombre_usuario: '',
    email: '',
    edad: '',
    numero: '',
    dni: '',
    contraseña: ''
  });

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await api.registrar(formData);
      console.log('Usuario registrado exitosamente:', response);

      navigate('/login');
    } catch (error) {
      console.error('Error al registrar usuario:', error);
    }
  };

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  return (
    <div className="container mt-5">
      <div className="card p-4">
        <h2 className="mb-4">Registro</h2>
        <form onSubmit={handleSubmit}>
          <div className="mb-3">
            <label htmlFor="nombres" className="form-label">Nombre:</label>
            <input type="text" className="form-control" id="nombres" name="nombres" value={formData.nombres} onChange={handleChange} required />
          </div>
          <div className="mb-3">
            <label htmlFor="apellidos" className="form-label">Apellidos:</label>
            <input type="text" className="form-control" id="apellidos" name="apellidos" value={formData.apellidos} onChange={handleChange} required />
          </div>
          <div className="mb-3">
            <label htmlFor="nombre_usuario" className="form-label">Nombre de usuario:</label>
            <input type="text" className="form-control" id="nombre_usuario" name="nombre_usuario" value={formData.nombre_usuario} onChange={handleChange} required />
          </div>
          <div className="mb-3">
            <label htmlFor="email" className="form-label">Email:</label>
            <input type="email" className="form-control" id="email" name="email" value={formData.email} onChange={handleChange} required />
          </div>
          <div className="mb-3">
            <label htmlFor="edad" className="form-label">Edad:</label>
            <input type="number" className="form-control" id="edad" name="edad" value={formData.edad} onChange={handleChange} required />
          </div>
          <div className="mb-3">
            <label htmlFor="numero" className="form-label">Número:</label>
            <input type="text" className="form-control" id="numero" name="numero" value={formData.numero} onChange={handleChange} required />
          </div>
          <div className="mb-3">
            <label htmlFor="dni" className="form-label">DNI:</label>
            <input type="text" className="form-control" id="dni" name="dni" value={formData.dni} onChange={handleChange} required />
          </div>
          <div className="mb-3">
            <label htmlFor="contraseña" className="form-label">Contraseña:</label>
            <input type="password" className="form-control" id="contraseña" name="contraseña" value={formData.contraseña} onChange={handleChange} required />
          </div>
          <button type="submit" className="btn btn-success">Registrar</button>
        </form>
      </div>
    </div>
  );
};

export default RegistroPage;
