package sistema.reclamos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarMail(String to, String subject, String texto) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(to);
        mensaje.setSubject(subject);
        mensaje.setText(texto);
        mensaje.setFrom("tu_correo@gmail.com");

        mailSender.send(mensaje);
    }
}
