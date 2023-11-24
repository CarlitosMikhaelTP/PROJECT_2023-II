import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom'; // Importa useHistory desde react-router-dom
import axios from 'axios';


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
    <form onSubmit={handleSubmit}>
      <div className='form-row'>
        <div className='form-column'>
          {/* Campos de primera columna */}
          <input type="text" name="nombres" placeholder="Nombres" onChange={handleChange} />
          <input type="text" name="apellidos" placeholder="Apellidos"  onChange={handleChange} />
          <input type="text" name="apodo" placeholder="Nombre de Usuario" onChange={handleChange} />
          <input type="text" name="direccion" placeholder="Direccion" onChange={handleChange} />
          <input type="number" name="edad" placeholder="Edad" onChange={handleChange} />
        </div>
        <div className='form-column'>
          {/* Campos de segunda columna */}
          <input type="text" name="celular" placeholder="Celular" onChange={handleChange} />
          <input type="text" name="dni" placeholder="Dni" onChange={handleChange} />
          <input type="email" name="email" placeholder="Email" onChange={handleChange} />
          <input type="password" name="password" placeholder="Password" onChange={handleChange} />
        </div>
      </div>
      <button type="submit">Register</button>
    </form>
  );
}

export default Register;
