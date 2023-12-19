package org.example.springboot.l_data;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class L_User {
    private String login;
    private String password;

//    public UserForm encoded(PasswordEncoder encoder) {
//        return new UserForm(login, email, encoder.encode(password));
//    }
}
