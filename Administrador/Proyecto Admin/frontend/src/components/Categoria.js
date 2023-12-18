import React, { useEffect, useState } from 'react';
import api from '../api';
import { Link } from 'react-router-dom';

const Categoria = () => {
  const [categorias, setCategorias] = useState([]);
  const [categoriaEditando, setCategoriaEditando] = useState(null);
  const [datosEdicion, setDatosEdicion] = useState({
    categoria_nombre: '',
    descripcion: '',
    estado: '',
  });
  const [filtroNombre, setFiltroNombre] = useState('');
  const [categoriasFiltradas, setCategoriasFiltradas] = useState([]);

  const fetchCategorias = async () => {
    try {
      const data = await api.obtenerCategoriasPaseador();
      setCategorias(data);
      setCategoriasFiltradas(filtrarPorNombre(data, filtroNombre));
    } catch (error) {
      console.error('Error al obtener categorías de paseadores:', error);
    }
  };

  useEffect(() => {
    fetchCategorias();
  }, [filtroNombre]);

  const eliminarCategoria = (id) => {
    api.eliminarCategoriaPaseador(id)
      .then(() => {
        fetchCategorias();
      })
      .catch((error) => console.error('Error al eliminar categoría de paseador:', error));
  };

  const handleEditar = (categoria) => {
    setCategoriaEditando(categoria);
    setDatosEdicion({
      categoria_nombre: categoria.categoria_nombre,
      descripcion: categoria.descripcion,
      estado: categoria.estado,
    });
  };

  const cancelarEdicion = () => {
    setCategoriaEditando(null);
    setDatosEdicion({
      categoria_nombre: '',
      descripcion: '',
      estado: '',
    });
  };

  const handleInputChangeEditarCategoria = (e) => {
    const { name, value } = e.target;

    setDatosEdicion((prevDatosEdicion) => ({
      ...prevDatosEdicion,
      [name]: value,
    }));
  };

  const editarCategoria = () => {
    if (categoriaEditando) {
      api.editarCategoriaPaseador(categoriaEditando.id_categoria, datosEdicion)
        .then(() => {
          fetchCategorias();
          cancelarEdicion();
        })
        .catch((error) => console.error('Error al editar categoría de paseador:', error));
    }
  };

  const filtrarPorNombre = (categorias, filtro) => {
    return categorias.filter((categoria) =>
      categoria.categoria_nombre.toLowerCase().includes(filtro.toLowerCase())
    );
  };

  const toggleEstadoCategoria = (id, nuevoEstado) => {
    api.editarCategoriaPaseador(id, { estado: nuevoEstado })
      .then(() => {
        fetchCategorias();
      })
      .catch((error) => console.error('Error al cambiar el estado de la categoría de paseador:', error));
  };

  const activarCategoria = (id) => {
    toggleEstadoCategoria(id, '1');
  };

  const desactivarCategoria = (id) => {
    toggleEstadoCategoria(id, '0');
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
            <a className="navbar-brand">Categorías</a>
            <form className="d-flex" role="search">
              <input
                className="form-control me-2"
                type="search"
                placeholder="Buscar por Nombre de Categoría"
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
              <th>ID Categoría</th>
              <th>Nombre Categoría</th>
              <th>Descripción</th>
              <th>Estado</th>
              <th>Acciones</th>
            </tr>
          </thead>
          <tbody>
            {categoriasFiltradas.map((categoria) => (
              <tr key={categoria.id_categoria}>
                <td>{categoria.id_categoria}</td>
                <td>
                  {categoriaEditando === categoria ? (
                    <input
                      type="text"
                      className="form-control"
                      name="categoria_nombre"
                      value={datosEdicion.categoria_nombre}
                      onChange={handleInputChangeEditarCategoria}
                    />
                  ) : (
                    categoria.categoria_nombre
                  )}
                </td>
                <td>
                  {categoriaEditando === categoria ? (
                    <input
                      type="text"
                      className="form-control"
                      name="descripcion"
                      value={datosEdicion.descripcion}
                      onChange={handleInputChangeEditarCategoria}
                    />
                  ) : (
                    categoria.descripcion
                  )}
                </td>
                <td>
                  {categoriaEditando === categoria ? (
                    <input
                      type="text"
                      className="form-control"
                      name="estado"
                      value={datosEdicion.estado}
                      onChange={handleInputChangeEditarCategoria}
                    />
                  ) : (
                    categoria.estado
                  )}
                </td>
                <td>
                  {categoriaEditando === categoria ? (
                    <>
                      <button onClick={editarCategoria} className="btn btn-success btn-sm">
                        Guardar
                      </button>
                      <button onClick={cancelarEdicion} className="btn btn-secondary btn-sm">
                        Cancelar
                      </button>
                    </>
                  ) : (
                    <>
                      <button onClick={() => handleEditar(categoria)} className="btn btn-warning btn-sm">
                        Editar
                      </button>
                      <button onClick={() => eliminarCategoria(categoria.id_categoria)} className="btn btn-danger btn-sm">
                        Eliminar
                      </button>
                      <button
                        onClick={() => toggleEstadoCategoria(categoria.id_categoria, categoria.estado === '1' ? '0' : '1')}
                        className={`btn btn-${categoria.estado === '1' ? 'danger' : 'success'} btn-sm`}
                      >
                        {categoria.estado === '1' ? 'Desactivar' : 'Activar'}
                      </button>
                      <button
                        onClick={() => desactivarCategoria(categoria.id_categoria)} 
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

export default Categoria;
