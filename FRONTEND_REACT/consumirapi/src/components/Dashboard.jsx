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
import logo from '../assets/css/img/Logo.jpeg';
import carrusel1 from '../assets/css/img/perro1.jpg';
import carrusel2 from '../assets/css/img/perro2.jpg';
import carrusel3 from '../assets/css/img/perro3.jpg';
import uno from '../assets/css/img/uno.jpg';
import dos from '../assets/css/img/dos.jpg';
import tres from '../assets/css/img/tres.jpg';
import iconoWsp from '../assets/css/img/iconoWsp.png';
import iconoLinkedin from '../assets/css/img/iconoLinkedin.png';
import iconoYoutube from '../assets/css/img/iconoYoutube.png';
import iconoFace from '../assets/css/img/iconoFace.jpg';
import IconoCelular from '../assets/css/img/celular.jpeg';

import '../assets/css/Dashboard.css';
import { initMDB, Carousel } from 'mdb-ui-kit'; // Importa initMDB y el componente Carousel de mdb-ui-kit
// Inicializa el componente Carousel de MDB
initMDB({ Carousel });


//Crear una clase que herede de React Component
class Dashboard extends React.Component{
    //creamos metodo render que retornara los elementos html
    render(){
        return(
            <React.Fragment>
              {/* NAVBAR DEL INDEX */}
               
               <nav className="navbar navbar-expand navbar-dark bg-dark">
                  <div className="container-fluid">
                      <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
                          <span className="navbar-toggler-icon"></span>
                      </button>
                      <Link className="navbar-brand" to="/">
                        <img src={logo} id="icon" alt="User Icon" className="logo-img rounded-pill"></img>
                      </Link>
                      <div className="collapse navbar-collapse" id="navbarTogglerDemo03">
                          <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                            <li className="nav-item px-3">
                              <Link to="/usertypeselection" className="nav-link active" href="#">Registrarme</Link>
                            </li>
                            <li className="nav-item px-3">
                              <Link to="/login" className="nav-link active" >Iniciar Sesión</Link>
                            </li>
                            <li className="nav-item px-3">
                              <Link to="/login" className="nav-link active" >Acerca de</Link>
                            </li>
                            <li className="nav-item px-3">
                              <Link to="/login" className="nav-link active" >Servicios</Link>
                            </li>
                          </ul>
                          <form className="d-flex">
                            <input className="form-control me-2" type="search" placeholder="Busca lo que necesitas !" aria-label="Search"/>
                            <button className="btn btn-outline-success" type="submit">Buscar</button>
                          </form>
                      </div>
                  </div>
                </nav>
                
                {/* AGREGANDO CARROUSEL SOLUCIONAR PROBLEMA DE MOVILIDAD DE CARRUSEL */}
                
                <div id="carouselBasicExample" class="carousel slide carousel-fade" data-mdb-ride="carousel" data-mdb-carousel-init>
                  <div class="carousel-indicators">
                    <button
                      type="button"
                      data-mdb-target="#carouselBasicExample"
                      data-mdb-slide-to="0"
                      class="active"
                      aria-current="true"
                      aria-label="Slide 1"
                    ></button>
                    <button
                      type="button"
                      data-mdb-target="#carouselBasicExample"
                      data-mdb-slide-to="1"
                      aria-label="Slide 2"
                    ></button>
                    <button
                      type="button"
                      data-mdb-target="#carouselBasicExample"
                      data-mdb-slide-to="2"
                      aria-label="Slide 3"
                    ></button>
                  </div>
                  <div class="carousel-inner">
                    <div class="carousel-item active">
                      <img src={carrusel1} class="d-block w-100" alt="Sunset Over the City"/>
                      <div class="carousel-caption d-none d-md-block bg-black bg-opacity-50 rounded-4">
                        <h1>UyWalky Llegó a Perú</h1>
                        <h3>La tranquilidad de tu mascota es nuestra prioridadd</h3>
                      </div>
                    </div>
                    <div class="carousel-item">
                      <img src={carrusel2} class="d-block w-100 " alt="Canyon at Nigh"/>
                      <div class="carousel-caption d-none d-md-block bg-black bg-opacity-50 rounded-4">
                        <h1>Acompañándolos siempre !!</h1>
                        <h2>Dale más calidad de vida a tu perro aún cuando no estás a su lado.</h2>
                      </div>
                    </div>
                    <div class="carousel-item">
                      <img src={carrusel3} class="d-block w-100" alt="Cliff Above a Stormy Sea"/>
                      <div class="carousel-caption d-none d-md-block bg-success bg-opacity-50 rounded-4">
                        <h1>Encuentra el cuidador perfecto para tu perro</h1>
                        <h3>Lo cuidaremos con el mismo amor que tú !!</h3>
                      </div>
                    </div>
                  </div>
                  <button class="carousel-control-prev" type="button" data-mdb-target="#carouselBasicExample" data-mdb-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                  </button>
                  <button class="carousel-control-next" type="button" data-mdb-target="#carouselBasicExample" data-mdb-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                  </button>
                </div>
                {/* Agregando Espacio Cómo funciona UyWalky */}
                <div className="container-fluid">
                <div className="row px-5 bg-white">
                        <div className="row col-md-12 mt-5 ">
                            <div className="bg-secondary bg-opacity-50">
                                <h2 className="text-start py-3">¿Cómo funciona UyWalky?</h2>
                            </div>
                        </div>
                        <div className="col-md-4">
                            <div className="row">
                              <div className="col-md-4">
                                 <img src={uno} class="d-block w-100 h-100" alt="Canyon at Nigh"/>
                              </div>
                              <div className="col-md-8 mt-4">
                                 <h3>Busca</h3>
                                 <p>Busca y contacta con cuidadores de confianza y con experiencia cerca de ti</p>
                              </div>
                            </div>
                        </div>
                        <div className="col-md-4"> 
                          <div className="row">
                            <div className="col-md-4">
                              <img src={dos} class="d-block w-100 h-90" alt="Canyon at Nigh"/>
                            </div>
                            <div className="col-md-8 mt-4">
                              <h3>Reserva</h3>
                              <p>Encuentra al cuidador adecuado para tu perro y paga online para contar con la cobertura veterinaria</p>
                            </div>
                          </div> 
                        </div>
                        <div className="col-md-4">
                           <div className="row">
                              <div className="col-md-4">
                                 <img src={tres} class="d-block w-100 h-90" alt="Canyon at Nigh"/>
                              </div>
                              <div className="col-md-8 mt-4">
                                 <h3>Relájate</h3>
                                 <p>Tu perro se divertirá y estará en familia y tú recibirás fotografías regularmente</p>
                              </div>
                           </div>
                        </div>
                 </div>
                 {/* BENEFICIOS POR USAR UyWalky */}
                 <div className="row px-5 bg-body-tertiary">
                        <div className="row col-md-12 mt-2">
                            <div className="bg-secondary bg-opacity-50">
                                <h2 className="text-start py-3">Beneficios de UyWalky</h2>
                            </div>
                        </div>
                        <div className="col-md-3 text-center py-4">
                            <div className="row py-2">
                                <img src={iconoWsp} class="d-block w-25 mx-auto" alt="Canyon at Nigh"/>
                            </div>
                            <div className="row">
                                <h4>+235.000 opiniones excelentes de otros dueños de perros</h4>
                            </div>   
                        </div>
                        <div className="col-md-3 text-center py-4">
                            <div className="row py-2">
                                <img src={iconoLinkedin} class="d-block w-25 mx-auto" alt="Canyon at Nigh"/>
                            </div>
                            <div className="row">
                                <h4>Cobertura veterinaria con cada reserva</h4>
                            </div>   
                        </div>
                        <div className="col-md-3 text-center py-4">
                            <div className="row py-2">
                                <img src={iconoFace} class="d-block w-25 mx-auto" alt="Canyon at Nigh"/>
                            </div>
                            <div className="row">
                                <h4>Cancelaciones gratuitas y garantía de devolución</h4>
                            </div>   
                        </div>
                        <div className="col-md-3 text-center py-4">
                            <div className="row py-2">
                                <img src={iconoYoutube} class="d-block w-25 mx-auto" alt="Canyon at Nigh"/>
                            </div>
                            <div className="row">
                                <h4>Soporte y Ayuda de nuestro equipo de Gudog</h4>
                            </div>   
                        </div>
                 </div>
                {/* CARDS */}
                <div class="card-group px-5 bg-body-tertiary">
                    <div class="card">
                      <img src="https://mdbcdn.b-cdn.net/img/new/standard/city/041.webp" class="card-img-top px-3" alt="Hollywood Sign on The Hill"/>
                      <div class="card-body">
                        <h5 class="card-title">José Delgado</h5>
                        <p class="card-text">
                          Todo perfecto desde el primer momento. Una pareja majísima. Se nota que tiene 
                          experiencia y buena mano. Máx ha estado estupendamente y ha dado un gran paseo 
                          por la Casa de Campo.
                        </p>
                      </div>
                      <div class="card-footer">
                        <small class="text-muted">Hace 1 semana</small>
                      </div>
                    </div>
                    <div class="card bg-body-tertiary">
                      <img src="https://mdbcdn.b-cdn.net/img/new/standard/city/042.webp" class="card-img-top px-3" alt="Palm Springs Road"/>
                      <div class="card-body">
                        <h5 class="card-title">Katia Barboza</h5>
                        <p class="card-text">
                          Katy es una excelente cuidadora. Con muchos conocimientos y muy 
                          atenta a todo. Nos mantuvo informados en todo momento. Además tiene 
                          una casa con mucho terreno, perfecta para que los peludos corran y lo pasen bien. 
                          Repetiremos sin duda.
                        </p>
                      </div>
                      <div class="card-footer">
                        <small class="text-muted">Publicado hace 3 díass</small>
                      </div>
                    </div>
                    <div class="card bg-body-tertiary">
                      <img src="https://mdbcdn.b-cdn.net/img/new/standard/city/043.webp" class="card-img-top px-3" alt="Los Angeles Skyscrapers"/>
                      <div class="card-body">
                        <h5 class="card-title">Alicia Julca</h5>
                        <p class="card-text">
                            Súper agradecida, se les nota que los peludos les encanta, me han mandado muchas fotos y vídeos 
                            de ella. Incluso llegué a temer que Ania no quisiera volver a casa, muchas gracias , un 10 para 
                            ti Alicia y Edu cuento con vosotros 
                        </p>
                      </div>
                      <div class="card-footer">
                        <small class="text-muted">Actualizado hace 3 días.</small>
                      </div>
                    </div>
                 </div>
                 <div class="d-grid gap-2 col-6 mx-auto py-5">
                          <button class="btn btn-secondary" type="button" data-mdb-ripple-init>
                              Leer Opiniones
                          </button>
                  </div>
                  </div>
                  {/* PREGUNTAS FRECUENTES */}
                  <div className="container">
                  <div className="col-md-12 text-center h2 px-5">
                        Preguntas Frecuentes
                  </div>
                  <div className="col-md-12 h3 text-start px-5 py-4">. ¿UyWalky es adecuado para mi perro?</div>
                  <div className="col-md-12 h5 px-5">
                      Creemos que todos los perros deberían ser cuidados por cuidadores cariñosos que les 
                      proporcionen atención personalizada, muchos paseos, tiempo de juego y mimos. Si buscas 
                      lo mismo para tu perro, Gudog te permite buscar, encontrar y reservar el cuidador perfecto.
                  </div>
                  <div className="col-md-12 h3 text-start px-5 py-4">. ¿Son seguros los cuidadores de UyWalky?</div>
                  <div className="col-md-12 h5 px-5">
                      Nos comprometemos a proporcionar un entorno seguro para la comunidad Gudog. Todos los cuidadores 
                      pasan por un estricto proceso de selección con el equipo de confianza y seguridad de Gudog, y solo el 
                      15% de los solicitantes son finalmente aprobados. Los perfiles de Gudog muestran la experiencia, las 
                      cualificaciones, el entorno del hogar y la zona del cuidador, así como las calificaciones y los comentarios 
                      de otros dueños/as de perros. Las reservas realizadas a través de Gudog también están cubiertas por 
                      nuestros Términos de Servicio, incluyendo la atención veterinaria para proteger a tu perro en caso de 
                      accidente o emergencia durante cualquier reserva.
                  </div>
                  <div className="col-md-12 h3 text-start px-5 py-4">. ¿Puedo conocer al cuidador antes de una reserva?</div>
                  <div className="col-md-12 h5 px-5">
                      ¡Por supuesto! Siempre recomendamos organizar un encuentro antes de la reserva. Esta es una oportunidad 
                      para ver el entorno de la casa y conocer a las mascotas que viven allí y comentar detalles importantes con 
                      el cuidador como; rutina de comidas, problemas médicos o de comportamiento, y los horarios de paseo.
                  </div>
                  <div className="col-md-12 h3 text-start px-5 py-4">. ¿Cómo puedo pagar una reserva?</div>
                  <div className="col-md-12 h5 px-5">
                      Una vez que hayas encontrado al cuidador perfecto para tu perro, Gudog hará que el pago sea sencillo. Aceptamos 
                      las principales tarjetas de crédito / débito, SOFORT y Giropay. El importe se cargará una vez que se confirme la 
                      reserva y podrás hablar y conocer al cuidador antes de la reserva. Todas las reservas de Gudog incluyen un reembolso 
                      del 100% en cualquier momento hasta 3 días antes del inicio de la reserva.¡Nunca realices el pago en efectivo! 
                      Esto pone en riesgo a ti y a tu perro y vulnera los Términos de servicio de Gudog.
                  </div>
                  <div className="col-md-12 h3 text-start px-5 py-4">. ¿Puedo cancelar una reserva?</div>
                  <div className="col-md-12 h5  px-5">
                      ¡Sí, por supuesto! Entendemos que los planes pueden cambiar, por eso todas las reservas de Gudog tienen un reembolso 
                      del 100% en cualquier momento hasta 3 días antes del inicio de una reserva.
                  </div>
                  </div>
                  {/* INIVTACION A USAR EL APLICATIVO DEL CELULAR */}
                  <div className="row mt-5 bg-dark px-5 py-5">
                    <div className="col-md-5 bg-white">
                      <img src={IconoCelular} class="d-block w-75 h-100 mx-auto" alt="" />
                    </div>
                    <div className="col-md-7 bg-body-secondary py-3 px-5">
                      <div className="text-center h1">Descarga la Aplicación de UyWalky</div>
                      <div className="text-center h3 mt-4">Busca cuidadores con experiencia cerca de ti</div>
                      <div className="text-center h5">Busca, reserva y paga el cuidador/a perfecto y recibe actualizaciones en tiempo real con cada reserva directamente en tu teléfono.</div>
                      <div className="text-center h3 mt-4">Encuentra el cuidador perfecto para tu perro</div>
                      <div className="text-center h5">Busca cuidadores de confianza con experiencia y selecciona el que mejor encaje con tu perro</div>
                      <div className="text-center h3 mt-4">Mensajes y Reserva</div>
                      <div className="text-center h5">Envía y recibe mensajes de tu cuidador/a, reserva y paga a través de la App de Gudog.</div>
                      <div className="text-center h3 mt-4">Recibe fotos y actualizaciones</div>
                      <div className="text-center h5">Tu perro tendrá un montón de diversión y cariño mientras tú recibes mensajes, fotos y actualizaciones en tiempo real.</div>
                    </div>
                  </div>
                  
                </React.Fragment>
              );
              }
}
 // Exportamos la clase para que la podamos usar
 export default Dashboard
 