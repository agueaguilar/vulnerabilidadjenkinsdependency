    import javax.swing.*;
    import java.awt.event.*;
    import org.json.simple.JSONObject;
    import org.json.simple.parser.JSONParser;
    import java.io.FileReader;

    public class LoginApp {
        public static void main(String[] args) {
            JFrame frame = new JFrame("Login");
            JLabel label1 = new JLabel("Usuario:");
            label1.setBounds(20, 20, 80, 30);
            JTextField userField = new JTextField();
            userField.setBounds(100, 20, 200, 30);

            JLabel label2 = new JLabel("Contraseña:");
            label2.setBounds(20, 70, 80, 30);
            JPasswordField passField = new JPasswordField();
            passField.setBounds(100, 70, 200, 30);

            JButton loginBtn = new JButton("Login");
            loginBtn.setBounds(100, 120, 80, 30);

            loginBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        JSONParser parser = new JSONParser();
                        Object obj = parser.parse(new FileReader("credentials.json"));
                        JSONObject jsonObject = (JSONObject) obj;
                        String username = (String) jsonObject.get("usuario");
                        String password = (String) jsonObject.get("contraseña");

                        if (userField.getText().equals(username) && new String(passField.getPassword()).equals(password)) {
                            JOptionPane.showMessageDialog(null, "Login Exitoso");
                        } else {
                            JOptionPane.showMessageDialog(null, "Login Fallido");
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });

            frame.add(label1); frame.add(userField);
            frame.add(label2); frame.add(passField);
            frame.add(loginBtn);

            frame.setSize(400, 250);
            frame.setLayout(null);
            frame.setVisible(true);
        }
    }
