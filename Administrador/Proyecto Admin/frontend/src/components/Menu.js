import React from 'react';
import { Link, Outlet } from 'react-router-dom';

const Menu = () => {
  return (
    <div className="container" style={{
      background: '#1D976C',
      background: '-webkit-linear-gradient(to right, #93F9B9, #1D976C)', 
      background: 'linear-gradient(to right, #93F9B9, #1D976C)' 
    }}>
      <h2>Menú</h2>
      <hr />
      <div className="row">
        <div className="col-md-6 mb-3">
          <div className="card" style={{ width: '18rem' }}>
            <img src="https://i.pinimg.com/474x/c0/d1/da/c0d1da39c107f4f840789bb58b890aeb.jpg" className="card-img-top" alt="..." />
            <div className="card-body">
              <h5 className="card-title">Usuarios</h5>
              <p className="card-text">Aqui podrá observar los usuarios registrados.</p>
              <Link to="/menu/usuarios" className="btn btn-primary">
                Vamos a Usuarios
              </Link>
            </div>
          </div>
        </div>
        <div className="col-md-6 mb-3">
          <div className="card" style={{ width: '18rem' }}>
            <img src="https://fececo.org.ar/wp-content/uploads/2022/06/personas-usuarios.png" className="card-img-top" alt="..." />
            <div className="card-body">
              <h5 className="card-title">Tipos de Usuarios</h5>
              <p className="card-text">Aqui podrá observar los tipos de usuarios.</p>
              <Link to="/menu/tipo_usuarios" className="btn btn-primary">
                Vamos a Tipos de Usuario
              </Link>
            </div>
          </div>
        </div>
        <div className="col-md-6 mb-3">
          <div className="card" style={{ width: '18rem' }}>
            <img src="https://magautos.cl/wp-content/uploads/2022/07/Reserva.png" className="card-img-top" alt="..." />
            <div className="card-body">
              <h5 className="card-title">Reservas</h5>
              <p className="card-text">Aqui podrá observar las reservas.</p>
              <Link to="/menu/reservas" className="btn btn-primary">
                Vamos a Reservas
              </Link>
            </div>
          </div>
        </div>
        <div className="col-md-6 mb-3">
          <div className="card" style={{ width: '18rem' }}>
            <img src="https://elcomercio.pe/resizer/mBGybaqXrcaKEHgxaqqFEVjViK8=/580x330/smart/filters:format(jpeg):quality(75)/arc-anglerfish-arc2-prod-elcomercio.s3.amazonaws.com/public/K6WKL3WUVZG35O7KCDM2X6LHH4.png" className="card-img-top" alt="..." />
            <div className="card-body">
              <h5 className="card-title">Paseos</h5>
              <p className="card-text">Aqui podrá observar los paseos.</p>
              <Link to="/menu/paseos" className="btn btn-primary">
                Vamos a Paseos
              </Link>
            </div>
          </div>
        </div>
        <div className="col-md-6 mb-3">
          <div className="card" style={{ width: '18rem' }}>
            <img src="https://s1.eestatic.com/2015/10/12/elandroidelibre/el_androide_libre_71003130_179986200_1706x960.jpg" className="card-img-top" alt="..." />
            <div className="card-body">
              <h5 className="card-title">Locacion Paseador</h5>
              <p className="card-text">Aqui podrá observar las locaciones de los paseadores.</p>
              <Link to="/menu/locacion_paseadores" className="btn btn-primary">
                Vamos a Locacion Paseador
              </Link>
            </div>
          </div>
        </div>
        <div className="col-md-6 mb-3">
          <div className="card" style={{ width: '18rem' }}>
            <img src="https://conceptodefinicion.de/wp-content/uploads/2019/02/Localizaci%C3%B3n-1.jpg" className="card-img-top" alt="..." />
            <div className="card-body">
              <h5 className="card-title">Locacion Propietario</h5>
              <p className="card-text">Aqui podrá observar las locaciones de los propietarios.</p>
              <Link to="/menu/locacion_propietarios" className="btn btn-primary">
                Vamos a Locacion Propietario
              </Link>
            </div>
          </div>
        </div>
        <div className="col-md-6 mb-3">
          <div className="card" style={{ width: '18rem' }}>
            <img src="https://img.freepik.com/vector-premium/revision-calificacion-cinco-estrellas-doradas_153791-769.jpg?w=2000" className="card-img-top" alt="..." />
            <div className="card-body">
              <h5 className="card-title">Calificaciones</h5>
              <p className="card-text">Aqui podrá observar las calificaciones.</p>
              <Link to="/menu/calificaciones" className="btn btn-primary">
                Vamos a Calificaciones
              </Link>
            </div>
          </div>
        </div>
        <div className="col-md-6 mb-3">
          <div className="card" style={{ width: '18rem' }}>
            <img src="https://elcomercio.pe/resizer/EQQnr17yPt_0wzreERLZ9Uwal0I=/620x0/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/H4OOD3NX3JAMFCQFGOXPQZILRA.jpg" className="card-img-top" alt="..." />
            <div className="card-body">
              <h5 className="card-title">Paseadores</h5>
              <p className="card-text">Aqui podrá observar a los paseadores.</p>
              <Link to="/menu/paseadores" className="btn btn-primary">
                Vamos a Paseadores
              </Link>
            </div>
          </div>
        </div>
        <div className="col-md-6 mb-3">
          <div className="card" style={{ width: '18rem' }}>
            <img src="https://estaticos-cdn.prensaiberica.es/clip/2d6619fe-4633-4442-8965-451e3ae2eadb_16-9-discover-aspect-ratio_default_0.jpg" className="card-img-top" alt="..." />
            <div className="card-body">
              <h5 className="card-title">Dueños</h5>
              <p className="card-text">Aqui podrá observar a los dueños.</p>
              <Link to="/menu/dueños" className="btn btn-primary">
                Vamos a Dueños
              </Link>
            </div>
          </div>
        </div>
        <div className="col-md-6 mb-3">
          <div className="card" style={{ width: '18rem' }}>
            <img src="https://elucabista.com/wp-content/uploads/2016/12/administradores.jpg" className="card-img-top" alt="..." />
            <div className="card-body">
              <h5 className="card-title">Administradores</h5>
              <p className="card-text">Aqui podrá observar a los administradores.</p>
              <Link to="/menu/administradores" className="btn btn-primary">
                Vamos a Administrador
              </Link>
            </div>
          </div>
        </div>
        <div className="col-md-6 mb-3">
          <div className="card" style={{ width: '18rem' }}>
            <img src="https://dlegaonline.es/wp-content/uploads/tags-y-categorias.jpg" className="card-img-top" alt="..." />
            <div className="card-body">
              <h5 className="card-title">Categorias</h5>
              <p className="card-text">Aqui podrá observar las categorias.</p>
              <Link to="/menu/categorias_paseador" className="btn btn-primary">
                Vamos a Categorias
              </Link>
            </div>
          </div>
        </div>
        <div className="col-md-6 mb-3">
          <div className="card" style={{ width: '18rem' }}>
            <img src="https://www.barakaldotiendaveterinaria.es/blog/wp-content/uploads/2021/11/tipos-de-mascotas-tener-en-casa.jpg" className="card-img-top" alt="..." />
            <div className="card-body">
              <h5 className="card-title">Tipos de Mascotas</h5>
              <p className="card-text">Aqui podrá observar los tipos de mascotas.</p>
              <Link to="/menu/tipos_mascota" className="btn btn-primary">
                Vamos a Tipos Mascotas
              </Link>
            </div>
          </div>
        </div>
        <div className="col-md-6 mb-3">
          <div className="card" style={{ width: '18rem' }}>
            <img src="https://perrocontento.com/wp-content/uploads/2014/07/Foto_Perros_Gatos.jpg" className="card-img-top" alt="..." />
            <div className="card-body">
              <h5 className="card-title">Mascotas</h5>
              <p className="card-text">Aqui podrá observar a las mascotas.</p>
              <Link to="/menu/mascotas" className="btn btn-primary">
                Vamos a Mascotas
              </Link>
            </div>
          </div>
        </div>
        <div className="col-md-6 mb-3">
          <div className="card" style={{ width: '18rem' }}>
            <img src="https://img.freepik.com/vector-premium/iconos-transacciones-linea_24877-72259.jpg" className="card-img-top" alt="..." />
            <div className="card-body">
              <h5 className="card-title">Transacciones</h5>
              <p className="card-text">Aqui podrá observar las transacciones.</p>
              <Link to="/menu/transacciones" className="btn btn-primary">
                Vamos a Transacciones
              </Link>
            </div>
          </div>
        </div>
        <div className="col-md-6 mb-3">
          <div className="card" style={{ width: '18rem' }}>
            <img src="https://c8.alamy.com/compes/2gpg387/iconos-de-pago-en-linea-nfc-innovador-movil-transaccion-internet-tarjetas-bancarias-dinero-vector-concepto-fotos-planas-2gpg387.jpg" className="card-img-top" alt="..." />
            <div className="card-body">
              <h5 className="card-title">Tipos de Transaccion</h5>
              <p className="card-text">Aqui podrá observar los tipos de transaccion.</p>
              <Link to="/menu/tipos_transaccion" className="btn btn-primary">
                Vamos a Tipos Transacion
              </Link>
            </div>
          </div>
        </div>
        <div className="col-md-6 mb-3">
          <div className="card" style={{ width: '18rem' }}>
            <img src="https://www.claseejecutiva.uc.cl/wp-content/uploads/2017/12/pueden-los-estados-triburarios-remplazar-a-los-estados-financierosOK-min-thegem-blog-timeline-large.jpg" className="card-img-top" alt="..." />
            <div className="card-body">
              <h5 className="card-title">Estados de las Transacciones</h5>
              <p className="card-text">Aqui podrá observar los estados de las transacciones.</p>
              <Link to="/menu/estados_transaccion" className="btn btn-primary">
                Vamos a Estados Transaccion
              </Link>
            </div>
          </div>
        </div>
      </div>
      <Outlet />
    </div>
  );
};

export default Menu;