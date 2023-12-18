from django.urls import path
from . import views

urlpatterns = [
    path('registrar/', views.registrar_administrador, name='registrar_administrador'),
    path('login/', views.login_administrador, name='login_administrador'),
    path('usuarios/', views.obtener_usuarios, name='obtener_usuarios'),
    path('usuarios/<int:pk>/', views.obtener_usuario, name='obtener_usuario'),
    path('tipo_usuarios/', views.obtener_tipo_usuarios, name='obtener_tipo_usuarios'),
    path('tipo_usuarios/<int:pk>/', views.obtener_tipo_usuario, name='obtener_tipo_usuario'),
    path('reservas/', views.obtener_reservas, name='obtener_reservas'),
    path('reservas/<int:pk>/', views.obtener_reserva, name='obtener_reserva'),
    path('paseos/', views.obtener_paseos, name='obtener_paseos'),
    path('paseos/<int:pk>/', views.obtener_paseo, name='obtener_paseo'),
    path('calificaciones/', views.obtener_calificaciones, name='obtener_calificaciones'),
    path('calificaciones/<int:pk>/', views.obtener_calificacion, name='obtener_calificacion'),
    path('paseadores/', views.obtener_paseadores, name='obtener_paseadores'),
    path('paseadores/<int:pk>/', views.obtener_paseador, name='obtener_paseador'),
    path('dueños/', views.obtener_dueños, name='obtener_dueños'),
    path('dueños/<int:pk>/', views.obtener_dueño, name='obtener_dueño'),
    path('administradores/', views.obtener_administradores, name='obtener_administradores'),
    path('administradores/<int:pk>/', views.obtener_administrador, name='obtener_administrador'),
    path('categorias_paseador/', views.obtener_categorias_paseador, name='obtener_categorias_paseador'),
    path('categorias_paseador/<int:pk>/', views.obtener_categoria_paseador, name='obtener_categoria_paseador'),
    path('tipos_mascota/', views.obtener_tipos_mascota, name='obtener_tipos_mascota'),
    path('tipos_mascota/<int:pk>/', views.obtener_tipo_mascota, name='obtener_tipo_mascota'),
    path('mascotas/', views.obtener_mascotas, name='obtener_mascotas'),
    path('mascotas/<int:pk>/', views.obtener_mascota, name='obtener_mascota'),
    path('transacciones/', views.obtener_transacciones, name='obtener_transacciones'),
    path('transacciones/<int:pk>/', views.obtener_transaccion, name='obtener_transaccion'),
    path('tipos_transaccion/', views.obtener_tipos_transaccion, name='obtener_tipos_transaccion'),
    path('tipos_transaccion/<int:pk>/', views.obtener_tipo_transaccion, name='obtener_tipo_transaccion'),
    path('estados_transaccion/', views.obtener_estados_transaccion, name='obtener_estados_transaccion'),
    path('estados_transaccion/<int:pk>/', views.obtener_estado_transaccion, name='obtener_estado_transaccion'),
    path('locacion_paseadores/', views.obtener_locacion_paseadores, name='obtener_locacion_paseadores'),
    path('locacion_paseadores/<int:pk>/', views.obtener_locacion_paseador, name='obtener_locacion_paseador'),
    path('locacion_propietarios/', views.obtener_locacion_propietarios, name='obtener_locacion_propietarios'),
    path('locacion_propietarios/<int:pk>/', views.obtener_locacion_propietario, name='obtener_locacion_propietario'),
]
