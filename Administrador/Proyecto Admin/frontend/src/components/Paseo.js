import React, { useEffect, useState } from 'react';
import api from '../api';
import { Link } from 'react-router-dom';

const Paseos = () => {
  const [paseos, setPaseos] = useState([]);
  const [paseoEditando, setPaseoEditando] = useState(null);
  const [datosEdicion, setDatosEdicion] = useState({
    id_reserva: '',
    fecha_paseo: '',
    duracion_real: '',
    lugar: '',
    comentario: '',
    calificacion: '',
    costo: '',
    estado: '',
  });
  const [busquedaLugar, setBusquedaLugar] = useState('');
  const [paseosFiltrados, setPaseosFiltrados] = useState([]);

  const fetchPaseos = async () => {
    try {
      const data = await api.obtenerPaseos();
      setPaseos(data);
      filtrarPaseos(data, busquedaLugar);
    } catch (error) {
      console.error('Error al obtener paseos:', error);
    }
  };

  useEffect(() => {
    fetchPaseos();
  }, [busquedaLugar]);

  const eliminarPaseo = (id) => {
    api.eliminarPaseo(id)
      .then(() => {
        fetchPaseos();
      })
      .catch((error) => console.error('Error al eliminar paseo:', error));
  };

  const handleEditar = (paseo) => {
    setPaseoEditando(paseo);
    setDatosEdicion({
      id_reserva: paseo.id_reserva.id_reserva,
      fecha_paseo: paseo.fecha_paseo,
      duracion_real: paseo.duracion_real,
      lugar: paseo.lugar,
      comentario: paseo.comentario,
      calificacion: paseo.calificacion,
      costo: paseo.costo,
      estado: paseo.estado,
    });
  };

  const cancelarEdicion = () => {
    setPaseoEditando(null);
    setDatosEdicion({
      id_reserva: '',
      fecha_paseo: '',
      duracion_real: '',
      lugar: '',
      comentario: '',
      calificacion: '',
      costo: '',
      estado: '',
    });
  };

  const handleInputChangeEditarPaseo = (e) => {
    const { name, value } = e.target;

    setDatosEdicion((prevDatosEdicion) => ({
      ...prevDatosEdicion,
      [name]: value,
    }));
  };

  const editarPaseo = () => {
    if (paseoEditando) {
      api.editarPaseo(paseoEditando.id_paseo, datosEdicion)
        .then(() => {
          fetchPaseos();
          cancelarEdicion();
        })
        .catch((error) => console.error('Error al editar paseo:', error));
    }
  };

  const filtrarPaseos = (paseos, busquedaLugar) => {
    const paseosFiltrados = paseos.filter((paseo) =>
      paseo.lugar.toLowerCase().includes(busquedaLugar.toLowerCase())
    );
    setPaseosFiltrados(paseosFiltrados);
  };

  const toggleEstadoPaseo = (id, nuevoEstado) => {
    api.editarPaseo(id, { estado: nuevoEstado })
      .then(() => {
        fetchPaseos();
      })
      .catch((error) => console.error('Error al cambiar el estado del paseo:', error));
  };

  const activarPaseo = (id) => {
    toggleEstadoPaseo(id, '1');
  };

  const desactivarPaseo = (id) => {
    toggleEstadoPaseo(id, '0');
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
            <a className="navbar-brand">Paseos</a>
            <form className="d-flex" role="search">
              <input
                className="form-control me-2"
                type="search"
                placeholder="Buscar por Lugar"
                aria-label="Buscar"
                value={busquedaLugar}
                onChange={(e) => setBusquedaLugar(e.target.value)}
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
              <th>ID Paseo</th>
              <th>ID Reserva</th>
              <th>Fecha Paseo</th>
              <th>Duración Real</th>
              <th>Lugar</th>
              <th>Comentario</th>
              <th>Calificación</th>
              <th>Costo</th>
              <th>Estado</th>
              <th>Acciones</th>
            </tr>
          </thead>
          <tbody>
            {paseosFiltrados.map((paseo) => (
              <tr key={paseo.id_paseo}>
                <td>{paseo.id_paseo}</td>
                <td>{paseo.id_reserva.id_reserva}</td>
                <td>
                  {paseoEditando === paseo ? (
                    <input
                      type="text"
                      className="form-control"
                      name="fecha_paseo"
                      value={datosEdicion.fecha_paseo}
                      onChange={handleInputChangeEditarPaseo}
                    />
                  ) : (
                    paseo.fecha_paseo
                  )}
                </td>
                <td>
                  {paseoEditando === paseo ? (
                    <input
                      type="text"
                      className="form-control"
                      name="duracion_real"
                      value={datosEdicion.duracion_real}
                      onChange={handleInputChangeEditarPaseo}
                    />
                  ) : (
                    paseo.duracion_real
                  )}
                </td>
                <td>
                  {paseoEditando === paseo ? (
                    <input
                      type="text"
                      className="form-control"
                      name="lugar"
                      value={datosEdicion.lugar}
                      onChange={handleInputChangeEditarPaseo}
                    />
                  ) : (
                    paseo.lugar
                  )}
                </td>
                <td>
                  {paseoEditando === paseo ? (
                    <input
                      type="text"
                      className="form-control"
                      name="comentario"
                      value={datosEdicion.comentario}
                      onChange={handleInputChangeEditarPaseo}
                    />
                  ) : (
                    paseo.comentario
                  )}
                </td>
                <td>
                  {paseoEditando === paseo ? (
                    <input
                      type="text"
                      className="form-control"
                      name="calificacion"
                      value={datosEdicion.calificacion}
                      onChange={handleInputChangeEditarPaseo}
                    />
                  ) : (
                    paseo.calificacion
                  )}
                </td>
                <td>
                  {paseoEditando === paseo ? (
                    <input
                      type="text"
                      className="form-control"
                      name="costo"
                      value={datosEdicion.costo}
                      onChange={handleInputChangeEditarPaseo}
                    />
                  ) : (
                    paseo.costo
                  )}
                </td>
                <td>
                  {paseoEditando === paseo ? (
                    <input
                      type="text"
                      className="form-control"
                      name="estado"
                      value={datosEdicion.estado}
                      onChange={handleInputChangeEditarPaseo}
                    />
                  ) : (
                    paseo.estado
                  )}
                </td>
                <td>
                  {paseoEditando === paseo ? (
                    <>
                      <button onClick={editarPaseo} className="btn btn-success btn-sm">
                        Guardar
                      </button>
                      <button onClick={cancelarEdicion} className="btn btn-secondary btn-sm">
                        Cancelar
                      </button>
                    </>
                  ) : (
                    <>
                      <button onClick={() => handleEditar(paseo)} className="btn btn-warning btn-sm">
                        Editar
                      </button>
                      <button onClick={() => eliminarPaseo(paseo.id_paseo)} className="btn btn-danger btn-sm">
                        Eliminar
                      </button>
                      <button
                        onClick={() => toggleEstadoPaseo(paseo.id_paseo, paseo.estado === '1' ? '0' : '1')}
                        className={`btn btn-${paseo.estado === '1' ? 'danger' : 'success'} btn-sm`}
                      >
                        {paseo.estado === '1' ? 'Desactivar' : 'Activar'}
                      </button>
                      <button
                        onClick={() => desactivarPaseo(paseo.id_paseo)}
                        className="btn btn-secondary btn-sm"
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

export default Paseos;
