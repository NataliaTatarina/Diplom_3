package stellarburger.proc;

import io.restassured.filter.log.ResponseLoggingFilter;
import stellarburgers.pojo.UserLoginResponse;

import static io.restassured.RestAssured.given;
import static org.apache.hc.core5.http.HttpStatus.SC_ACCEPTED;


public class DeleteUserAPI {
    public static void deleteUserAPI(String userEmail, String userPassword) {
        // Сформировать JSON для запроса
        String json = "{\"email\":\"" + userEmail + "\"," + "\n" +
                "\"password\":\"" + userPassword + "\"}";
        System.out.println(json);
        // Получить token
        String token =
                (given()
                        .baseUri("https://stellarburgers.nomoreparties.site/api/")
                        .header("Content-type", "application/json")
                        .filter(new ResponseLoggingFilter())
                        .and()
                        .body(json)
                        .when()
                        .post("auth/login")
                        .body()
                        .as(UserLoginResponse.class)).getAccessToken().replace("Bearer ", "");
        System.out.println(token);
        // Удалить учетную запись пользователя через API
        given()
                .baseUri("https://stellarburgers.nomoreparties.site/api/")
                .header("Content-type", "application/json")
                .filter(new ResponseLoggingFilter())
                .and()
                .body(json)
                .auth().oauth2(token)
                .when()
                .delete("auth/user")
                .then()
                .statusCode(SC_ACCEPTED);
    }
}
