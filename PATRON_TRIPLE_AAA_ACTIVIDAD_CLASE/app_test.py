# ===============================
# FUNCIÓN LOGIN
# ===============================

def login(usuario, password, base_datos):

    if usuario not in base_datos:
        return "Usuario no existe"

    if base_datos[usuario]["bloqueado"]:
        return "Usuario bloqueado"

    if base_datos[usuario]["password"] != password:
        return "Password incorrecto"

    return "Login exitoso"














# AAA)


def test_usuario_bloqueado():

    # ARRANGE
    base_datos = {
        "juan": {"password": "1234", "bloqueado": True},
        "ana": {"password": "abcd", "bloqueado": False},
        "pedro": {"password": "9999", "bloqueado": False}
    }

    # ACT
    resultado = login("juan", "1234", base_datos)

    # ASSERT
    assert resultado == "Usuario bloqueado"


def test_login_exitoso():

    # ARRANGE
    base_datos = {
        "juan": {"password": "1234", "bloqueado": True},
        "ana": {"password": "abcd", "bloqueado": False},
        "pedro": {"password": "9999", "bloqueado": False}
    }

    # ACT
    resultado = login("ana", "abcd", base_datos)

    # ASSERT
    assert resultado == "Login exitoso"


def test_password_incorrecto():

    # ARRANGE
    base_datos = {
        "juan": {"password": "1234", "bloqueado": True},
        "ana": {"password": "abcd", "bloqueado": False},
        "pedro": {"password": "9999", "bloqueado": False}
    }

    # ACT
    resultado = login("pedro", "0000", base_datos)

    # ASSERT
    assert resultado == "Password incorrecto"


def test_usuario_no_existe():

    # ARRANGE
    base_datos = {
        "juan": {"password": "1234", "bloqueado": True},
        "ana": {"password": "abcd", "bloqueado": False},
        "pedro": {"password": "9999", "bloqueado": False}
    }

    # ACT
    resultado = login("maria", "1234", base_datos)

    # ASSERT
    assert resultado == "Usuario no existe"


# ===============================
# EJECUCIÓN
# ===============================

if __name__ == "__main__":
    test_usuario_bloqueado()
    test_login_exitoso()
    test_password_incorrecto()
    test_usuario_no_existe()

    print(" TODOS LOS TEST PASARON CORRECTAMENTE")