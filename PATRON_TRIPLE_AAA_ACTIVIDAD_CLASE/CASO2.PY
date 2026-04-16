from login import login


def test_usuario_bloqueado():

    # ===== ARRANGE =====
    base_datos = {
        "juan": {"password": "1234", "bloqueado": True},
        "ana": {"password": "abcd", "bloqueado": False},
        "pedro": {"password": "9999", "bloqueado": False}
    }
    usuario = "juan"
    password = "1234"

    # ===== ACT =====
    resultado = login(usuario, password, base_datos)

    # ===== ASSERT =====
    assert resultado == "Usuario bloqueado"


def test_login_exitoso():

    # ===== ARRANGE =====
    base_datos = {
        "juan": {"password": "1234", "bloqueado": True},
        "ana": {"password": "abcd", "bloqueado": False},
        "pedro": {"password": "9999", "bloqueado": False}
    }
    usuario = "ana"
    password = "abcd"

    # ===== ACT =====
    resultado = login(usuario, password, base_datos)

    # ===== ASSERT =====
    assert resultado == "Login exitoso"


def test_password_incorrecto():

    # ===== ARRANGE =====
    base_datos = {
        "juan": {"password": "1234", "bloqueado": True},
        "ana": {"password": "abcd", "bloqueado": False},
        "pedro": {"password": "9999", "bloqueado": False}
    }
    usuario = "pedro"
    password = "0000"

    # ===== ACT =====
    resultado = login(usuario, password, base_datos)

    # ===== ASSERT =====
    assert resultado == "Password incorrecto"


def test_usuario_no_existe():

    # ===== ARRANGE =====
    base_datos = {
        "juan": {"password": "1234", "bloqueado": True},
        "ana": {"password": "abcd", "bloqueado": False},
        "pedro": {"password": "9999", "bloqueado": False}
    }
    usuario = "maria"
    password = "1234"

    # ===== ACT =====
    resultado = login(usuario, password, base_datos)

    # ===== ASSERT =====
    assert resultado == "Usuario no existe"


if __name__ == "__main__":
    test_usuario_bloqueado()
    test_login_exitoso()
    test_password_incorrecto()
    test_usuario_no_existe()
    print("TODOS LOS TEST PASARON CORRECTAMENTE ")