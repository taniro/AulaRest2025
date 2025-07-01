package ufrn.br.aularest2025.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String rua;
    String numero;
}