package sistema.reclamos.util;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordUtils {
	
	public static String encriptar(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean verificar(String passwordPlano, String passwordEncriptada) {
        return BCrypt.checkpw(passwordPlano, passwordEncriptada);
    }
}