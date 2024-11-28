package io.ordini.clients.domain.model;

import io.ordini.clients.domain.exception.ModelValidationIllegalArgumentException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientModel {

  private UUID id;
  private String name;
  private String email;
  private String phone;
  private String cellphone;
  private String document;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  public void validateEmail(String email) {
    if (email == null || !email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
      throw new ModelValidationIllegalArgumentException("Invalid email format", HttpStatus.BAD_REQUEST);
    }
  }

  public void validateCPF(String cpf) {
    // Limpa o CPF, removendo caracteres especiais
    String cleanCPF = cpf == null ? "" : cpf.replaceAll("[^0-9]", "");

    // Verifica se o CPF contém 11 dígitos
    if (cleanCPF.length() != 11) {
      throw new ModelValidationIllegalArgumentException("Invalid CPF length. Must contain 11 digits.", HttpStatus.BAD_REQUEST);
    }

    // Verifica se o CPF não é formado por números repetidos (ex: "111.111.111-11")
    if (cleanCPF.matches("(\\d)\\1{10}")) {
      throw new ModelValidationIllegalArgumentException("Invalid CPF. Cannot contain repeated digits.", HttpStatus.BAD_REQUEST);
    }

    // Arrays de pesos para o cálculo dos dígitos verificadores
    int[] weights1 = {10, 9, 8, 7, 6, 5, 4, 3, 2};
    int[] weights2 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

    // Função lambda para calcular os dígitos verificadores
    java.util.function.BiFunction<String, int[], Integer> calculateDigit = (base, weights) -> {
      int sum = 0;
      for (int i = 0; i < base.length(); i++) {
        sum += Character.getNumericValue(base.charAt(i)) * weights[i];
      }
      int remainder = sum % 11;
      return remainder < 2 ? 0 : 11 - remainder;
    };

    // Calcula os dois dígitos verificadores
    int firstDigit = calculateDigit.apply(cleanCPF.substring(0, 9), weights1);
    int secondDigit = calculateDigit.apply(cleanCPF.substring(0, 9) + firstDigit, weights2);

    // Verifica os dígitos calculados com os fornecidos
    String calculatedCPF = cleanCPF.substring(0, 9) + firstDigit + secondDigit;
    if (!cleanCPF.equals(calculatedCPF)) {
      throw new ModelValidationIllegalArgumentException("Invalid CPF. Check the document.", HttpStatus.BAD_REQUEST);
    }
  }

}
