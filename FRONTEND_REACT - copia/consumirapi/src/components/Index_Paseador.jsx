//Anotacion jsx para crear los componentes
//Llamamos a la librería de React
import React from "react";
//Anotacion jsx para crear los componentes
//servicios
import {Apiurl} from '../services/apirest'; 
//Importando Axios
import axios from 'axios';
import { Link } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';

//Crear una clase que herede de React Component
class Index_Paseador extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      categorias: [
        { id: 1, nombre: 'Experto' },
        { id: 2, nombre: 'Novato' },
        { id: 3, nombre: 'Exótico' },
      ],
      selectedCategoria: '',
      tarifas: {
        Experto: 20,
        Novato: 15,
        Exótico: 30,
      },
      formData: {
        idUsuario: localStorage.getItem('id') || '',
        idCategoria: '', 
        calificacion: '',
        descripcion: '',
        experiencia: '',
        ubicacion: '',
        tarifa: '',
        saldo: 0,
        disponibilidad: false,
      },
    };
  }

  handleInputChange = (event) => {
    const { name, value } = event.target;
    this.setState((prevState) => ({
      formData: {
        ...prevState.formData,
        [name]: value,
      },
    }));
  };

  handleCategoriaChange = (event) => {
    const selectedCategoria = event.target.value;
    const { categorias, tarifas, formData } = this.state;
  
    // Busca la categoría seleccionada en la lista de categorías
    const selectedCategory = categorias.find(
      (categoria) => categoria.nombre === selectedCategoria
    );
  
    // Obtiene el ID y tarifa correspondiente a la categoría seleccionada
    const selectedCategoryId = selectedCategory ? selectedCategory.id : '';
    const tarifa = tarifas[selectedCategoria] || '';
  
    this.setState((prevState) => ({
      selectedCategoria,
      formData: {
        ...prevState.formData,
        idCategoria: selectedCategoryId, // Actualiza el ID de la categoría en el formulario
        tarifa, // Actualiza la tarifa en el formulario
      },
    }));
  };
  handleSubmit = async (event) => {
    event.preventDefault();
    const { formData } = this.state;
  
    try {
      const response = await axios.post('http://localhost:8080/api/v1/paseador/register', formData);
      console.log('Registro exitoso:', response.data);
      // Redirigir a la página principal ('/')
      // Si estás utilizando React Router, puedes redirigir usando history.push('/')
      // Por ejemplo: this.props.history.push('/');
    } catch (error) {
      console.error('Error al registrar el paseador:', error);
    }
  };
  

    //creamos metodo render que retornara los elementos html
    render(){
      const { categorias, selectedCategoria, formData } = this.state;
        return(
            <React.Fragment>
            <nav className="navbar navbar-expand-lg navbar-light bg-secondary">
  <a className="navbar-brand" href="#">Mi Sitio</a>
  <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span className="navbar-toggler-icon"></span>
  </button>
  <div className="collapse navbar-collapse" id="navbarNav">
    <ul className="navbar-nav ml-auto">
      <li className="nav-item">
        <Link to="/usertypeselection" className="nav-link" href="#">Registrarme</Link>
      </li>
      <li className="nav-item">
        <Link to="/login" className="nav-link" >Iniciar Sesión</Link>
      </li>
      <li className="nav-item">
        <Link className="nav-link" to="/userProfile">Perfil</Link>
      </li>
      <li className="nav-item">
        <a className="nav-link" href="#">Registrar Datos para Propietario</a>
      </li>
      <li className="nav-item">
        <a className="nav-link" href="#">Registrar Mascota</a>
      </li>
      <li className="nav-item">
        <a className="nav-link" href="#">Buscar Paseador</a>
      </li>
    </ul>
  </div>
</nav>
{/* Agregar formulario para registrar un paseador */}
<div className="container mt-4">
          <h2>Registrar Paseador</h2>
          <form onSubmit={this.handleSubmit}>
            {/* Input para la calificación, descripción, etc. */}
            {/* Ejemplo de campo para la categoría */}
            <div className="form-group">
              <label htmlFor="categoria">Categoría</label>
              <select
                className="form-control"
                id="categoria"
                name="categoria"
                value={selectedCategoria}
                onChange={this.handleCategoriaChange}
              >
                <option value="">Seleccione una categoría</option>
                {categorias.map((categoria) => (
                  <option key={categoria.id} value={categoria.nombre}>
                    {categoria.nombre}
                  </option>
                ))}
              </select>
            </div>

            {/* Resto de campos para la información del paseador */}
            {/* Ejemplo: input para la calificación */}
            <div className="form-group">
              <label htmlFor="calificacion">Calificación</label>
              <input
                type="text"
                className="form-control"
                id="calificacion"
                name="calificacion"
                value={formData.calificacion}
                onChange={this.handleInputChange}
              />
            </div>

            <div className="form-group">
              <label htmlFor="descripcion">Tu descripcion</label>
              <input
                type="text"
                className="form-control"
                id="descripcion"
                name="descripcion"
                value={formData.descripcion}
                onChange={this.handleInputChange}
              />
            </div>

            <div className="form-group">
              <label htmlFor="experiencia">Experiencia</label>
              <input
                type="text"
                className="form-control"
                id="experiencia"
                name="experiencia"
                value={formData.experiencia}
                onChange={this.handleInputChange}
              />
            </div>

            <div className="form-group">
              <label htmlFor="calificacion">Tarifa</label>
              <input
                type="number"
                className="form-control"
                id="tarifa"
                name="tarifa"
                value={formData.tarifa}
                onChange={this.handleInputChange}
              />
            </div>

            <div className="form-group">
              <label htmlFor="saldo">Saldo</label>
              <input
                type="text"
                className="form-control"
                id="saldo"
                name="saldo"
                value={formData.saldo}
                onChange={this.handleInputChange}
              />
            </div>

            <div className="form-group">
              <label htmlFor="ubicacion">Ubicación</label>
              <input
                type="text"
                className="form-control"
                id="ubicacion"
                name="ubicacion"
                value={formData.ubicacion}
                onChange={this.handleInputChange}
              />
            </div>

            <div className="form-group">
              <label htmlFor="ubicacion">Disponibilidad</label>
              <input
                type="text"
                className="form-control"
                id="disponibilidad"
                name="disponibilidad"
                value={formData.disponibilidad}
                onChange={this.handleInputChange}
              />
            </div>

            {/* ... (otros campos del formulario) ... */}

            <button type="submit" className="btn btn-primary">
              Registrarse como paseador
            </button>
          </form>
        </div>
</React.Fragment>
    );
    }
}
 // Exportamos la clase para que la podamos usar
 export default Index_Paseador
 