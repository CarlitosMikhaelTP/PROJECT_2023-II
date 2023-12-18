import React, { useEffect, useState } from 'react';
import api from '../api';
import { Link } from 'react-router-dom';

const Mascotas = () => {
  const [mascotas, setMascotas] = useState([]);
  const [mascotaEditando, setMascotaEditando] = useState(null);
  const [datosEdicion, setDatosEdicion] = useState({
    id_tipo_mascota: '',
    nombre: '',
    raza: '',
    peso: '',
    edad: '',
    necesidades: '',
    estado: '',
    id_propietario: '', // Nuevo campo
  });
  const [filtroNombre, setFiltroNombre] = useState('');
  const [mascotasFiltradas, setMascotasFiltradas] = useState([]);

  const fetchMascotas = async () => {
    try {
      const data = await api.obtenerMascotas();
      setMascotas(data);
      setMascotasFiltradas(filtrarPorNombre(data, filtroNombre));
    } catch (error) {
      console.error('Error al obtener mascotas:', error);
    }
  };

  useEffect(() => {
    fetchMascotas();
  }, [filtroNombre]);

  const eliminarMascota = (id) => {
    api.eliminarMascota(id)
      .then(() => {
        fetchMascotas();
      })
      .catch((error) => console.error('Error al eliminar mascota:', error));
  };

  const handleEditar = (mascota) => {
    setMascotaEditando(mascota);
    setDatosEdicion({
      id_tipo_mascota: mascota.id_tipo_mascota.id_tipo_mascota,
      nombre: mascota.nombre,
      raza: mascota.raza,
      peso: mascota.peso,
      edad: mascota.edad,
      necesidades: mascota.necesidades,
      estado: mascota.estado,
      id_propietario: mascota.id_propietario, // Nuevo campo
    });
  };

  const cancelarEdicion = () => {
    setMascotaEditando(null);
    setDatosEdicion({
      id_tipo_mascota: '',
      nombre: '',
      raza: '',
      peso: '',
      edad: '',
      necesidades: '',
      estado: '',
      id_propietario: '', // Nuevo campo
    });
  };

  const handleInputChangeEditarMascota = (e) => {
    const { name, value } = e.target;

    setDatosEdicion((prevDatosEdicion) => ({
      ...prevDatosEdicion,
      [name]: value,
    }));
  };

  const editarMascota = () => {
    if (mascotaEditando) {
      api.editarMascota(mascotaEditando.id_mascota, datosEdicion)
        .then(() => {
          fetchMascotas();
          cancelarEdicion();
        })
        .catch((error) => console.error('Error al editar mascota:', error));
    }
  };

  const filtrarPorNombre = (mascotas, filtro) => {
    return mascotas.filter((mascota) =>
      mascota.nombre.toLowerCase().includes(filtro.toLowerCase())
    );
  };

  const toggleEstadoMascota = (id, nuevoEstado) => {
    api.editarMascota(id, { estado: nuevoEstado })
      .then(() => {
        fetchMascotas();
      })
      .catch((error) => console.error('Error al cambiar el estado de la mascota:', error));
  };

  const activarMascota = (id) => {
    toggleEstadoMascota(id, '1');
  };

  const desactivarMascota = (id) => {
    toggleEstadoMascota(id, '0');
  };

  return (
    <div style={{
      background: '#1D976C',
      background: '-webkit-linear-gradient(to right, #93F9B9, #1D976C)', 
      background: 'linear-gradient(to right, #93F9B9, #1D976C)' 
    }}>
      <div className="d-flex justify-content-between align-items-center">
      </div>
      <div className="mb-3">
        <nav className="navbar bg-dark border-bottom border-body" data-bs-theme="dark">
          <div className="container-fluid">
            <a className="navbar-brand">Mascotas</a>
            <form className="d-flex" role="search">
              <input
                className="form-control me-2"
                type="search"
                placeholder="Buscar por Nombre"
                aria-label="Buscar"
                value={filtroNombre}
                onChange={(e) => setFiltroNombre(e.target.value)}
              />
              <button className="btn btn-outline-success" type="submit">
                Buscar
              </button>
              <Link to="/menu" className="btn btn-primary">
                Volver al Menú
              </Link>
            </form>
          </div>
        </nav>
      </div>
      <div className="table-responsive">
        <table className="table table-striped">
          <thead>
            <tr>
              <th>ID Mascota</th>
              <th>ID Tipo Mascota</th>
              <th>ID Propietario</th>
              <th>Nombre</th>
              <th>Raza</th>
              <th>Peso</th>
              <th>Edad</th>
              <th>Necesidades</th>
              <th>Estado</th>
              <th>Acciones</th>
            </tr>
          </thead>
          <tbody>
            {mascotasFiltradas.map((mascota) => (
              <tr key={mascota.id_mascota}>
                <td>{mascota.id_mascota}</td>
                <td>
                  {mascotaEditando === mascota ? (
                    <input
                      type="text"
                      className="form-control"
                      name="id_tipo_mascota"
                      value={datosEdicion.id_tipo_mascota}
                      onChange={handleInputChangeEditarMascota}
                    />
                  ) : (
                    mascota.id_tipo_mascota.id_tipo_mascota
                  )}
                </td>
                <td>
                  {mascotaEditando === mascota ? (
                    <input
                      type="text"
                      className="form-control"
                      name="id_propietario"
                      value={datosEdicion.id_propietario}
                      onChange={handleInputChangeEditarMascota}
                    />
                  ) : (
                    mascota.id_propietario
                  )}
                </td>
                <td>
                  {mascotaEditando === mascota ? (
                    <input
                      type="text"
                      className="form-control"
                      name="nombre"
                      value={datosEdicion.nombre}
                      onChange={handleInputChangeEditarMascota}
                    />
                  ) : (
                    mascota.nombre
                  )}
                </td>
                <td>
                  {mascotaEditando === mascota ? (
                    <input
                      type="text"
                      className="form-control"
                      name="raza"
                      value={datosEdicion.raza}
                      onChange={handleInputChangeEditarMascota}
                    />
                  ) : (
                    mascota.raza
                  )}
                </td>
                <td>
                  {mascotaEditando === mascota ? (
                    <input
                      type="text"
                      className="form-control"
                      name="peso"
                      value={datosEdicion.peso}
                      onChange={handleInputChangeEditarMascota}
                    />
                  ) : (
                    mascota.peso
                  )}
                </td>
                <td>
                  {mascotaEditando === mascota ? (
                    <input
                      type="text"
                      className="form-control"
                      name="edad"
                      value={datosEdicion.edad}
                      onChange={handleInputChangeEditarMascota}
                    />
                  ) : (
                    mascota.edad
                  )}
                </td>
                <td>
                  {mascotaEditando === mascota ? (
                    <input
                      type="text"
                      className="form-control"
                      name="necesidades"
                      value={datosEdicion.necesidades}
                      onChange={handleInputChangeEditarMascota}
                    />
                  ) : (
                    mascota.necesidades
                  )}
                </td>
                <td>
                  {mascotaEditando === mascota ? (
                    <input
                      type="text"
                      className="form-control"
                      name="estado"
                      value={datosEdicion.estado}
                      onChange={handleInputChangeEditarMascota}
                    />
                  ) : (
                    mascota.estado
                  )}
                </td>
                <td>
                  {mascotaEditando === mascota ? (
                    <>
                      <button onClick={editarMascota} className="btn btn-success btn-sm">
                        Guardar
                      </button>
                      <button onClick={cancelarEdicion} className="btn btn-secondary btn-sm">
                        Cancelar
                      </button>
                    </>
                  ) : (
                    <>
                      <button onClick={() => handleEditar(mascota)} className="btn btn-warning btn-sm">
                        Editar
                      </button>
                      <button onClick={() => eliminarMascota(mascota.id_mascota)} className="btn btn-danger btn-sm">
                        Eliminar
                      </button>
                      <button
                        onClick={() => toggleEstadoMascota(mascota.id_mascota, mascota.estado === '1' ? '0' : '1')}
                        className={`btn btn-${mascota.estado === '1' ? 'danger' : 'success'} btn-sm`}
                      >
                        {mascota.estado === '1' ? 'Desactivar' : 'Activar'}
                      </button>
                      <button
                        onClick={() => desactivarMascota(mascota.id_mascota)}
                        className={`btn btn-secondary btn-sm`}
                      >
                        Desactivar
                      </button>
                    </>
                  )}
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default Mascotas;
