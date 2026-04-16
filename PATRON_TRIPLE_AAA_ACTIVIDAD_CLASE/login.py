def login(usuario, password, base_datos):
    """
    Valida el login de un usuario.
    
    Args:
        usuario: nombre del usuario
        password: contraseña ingresada
        base_datos: diccionario con datos de usuarios
    
    Returns:
        str: mensaje de resultado del login
    """
    # Verificar si el usuario existe
    if usuario not in base_datos:
        return "Usuario no existe"
    
    # Obtener datos del usuario
    datos_usuario = base_datos[usuario]
    
    # Verificar si el usuario está bloqueado
    if datos_usuario.get("bloqueado", False):
        return "Usuario bloqueado"
    
    # Verificar contraseña
    if datos_usuario["password"] != password:
        return "Contraseña incorrecta"
    
    return "Login exitoso"
