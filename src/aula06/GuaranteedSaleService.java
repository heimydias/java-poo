//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//import java.util.concurrent.TimeUnit;
//
//@RequiredArgsConstructor
//@Service
//@Slf4j
//public class GuaranteedSaleService {
//
//    private static final int MAX_RETRIES = 3;
//    private static final int RETRY_INTERVAL = 30; // Intervalo em minutos
//
//    private final RestTemplate restTemplateAntiFraude;
//    private final IParametersRepository parametersRepository;
//
//    @Value("${STC_API_CHBK_CHARGEBACK_BY_STATUS}")
//    private String endpointAPIChargeback;
//
//    public String executeAntiFraude(Long idCase, Long nuEc) throws Exception {
//        if (parametersRepository.enablePostAntiFraude()) {
//            HttpHeaders headers = new HttpHeaders();
//            String xFunctionsClientId = parametersRepository.headerXFunctionsClientId();
//
//            if (xFunctionsClientId != null) {
//                headers.add("x-functions-clientid", xFunctionsClientId);
//                ResponseEntity<Object> responseApiChargeback = postForAPICHBK(headers, idCase, nuEc);
//
//                log.info("[PréCHBK ANTI-FRAUDE] statusCode {} retornado pela API-CHBK p/ recuperar chargeback {}", responseApiChargeback.getStatusCode(), nuEc);
//
//                if (responseApiChargeback.getStatusCode().is2xxSuccessful()) {
//                    return postAntiFraude(responseApiChargeback, headers, nuEc);
//                } else {
//                    log.error("[PréCHBK ANTI-FRAUDE] resposta Não OK retornada pela API-CHBK p/ recuperar chargeback, idCase {}, EC {}", idCase, nuEc);
//                    throw new AntiFraudeException("Resposta Não OK (" + responseApiChargeback.getStatusCode() + ") retornada pela API de chargeback, idCase " + idCase + " nuEC " + nuEc);
//                }
//            } else {
//                log.error("[PréCHBK ANTI-FRAUDE] x-functions-clientid não encontrado");
//                throw new AntiFraudeException("x-functions-clientid não encontrado");
//            }
//        } else {
//            log.info("[PréCHBK ANTI-FRAUDE] Post AntiFraude desabilitado");
//            return "";
//        }
//    }
//
//    private String postAntiFraude(ResponseEntity<Object> responseApiChargeback, HttpHeaders headers, Long nuEc) throws Exception {
//        if (responseApiChargeback.getBody() != null) {
//            String chargeback = ((ArrayList<String>) ((LinkedHashMap<String, Object>) responseApiChargeback.getBody()).get("content")).get(0);
//            ObjectMapper mapper = new ObjectMapper();
//            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//            mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
//            String json = mapper.writeValueAsString(chargeback);
//            HttpEntity<String> entity = new HttpEntity<>(json, headers);
//
//            int attempts = 0;
//            while (attempts < MAX_RETRIES) {
//                try {
//                    ResponseEntity<Object> response = restTemplateAntiFraude.postForEntity(parametersRepository.endpointAntiFraude(), entity, Object.class);
//                    if (response.getStatusCode().is2xxSuccessful()) {
//                        return String.valueOf(nuEc);
//                    } else {
//                        log.error("[PréCHBK ANTI-FRAUDE] resposta Não OK para o estabelecimento comercial {}", nuEc);
//                        throw new AntiFraudeException("Resposta Não OK (" + response.getStatusCode() + ") retornada pelo estabelecimento comercial " + nuEc);
//                    }
//                } catch (Exception e) {
//                    log.error("[PréCHBK ANTI-FRAUDE] Erro ao enviar a requisição para o estabelecimento comercial {}, tentativa {}/{}", nuEc, attempts + 1, MAX_RETRIES, e);
//                    attempts++;
//                    if (attempts < MAX_RETRIES) {
//                        log.info("[PréCHBK ANTI-FRAUDE] Tentativa {}/{}. Tentando novamente em {} minutos.", attempts, MAX_RETRIES, RETRY_INTERVAL);
//                        TimeUnit.MINUTES.sleep(RETRY_INTERVAL);
//                    } else {
//                        throw e; // Re-throw the last exception after max retries
//                    }
//                }
//            }
//            // Se o loop terminar sem retornar uma resposta bem-sucedida, lança uma exceção
//            throw new AntiFraudeException("Número máximo de tentativas alcançado sem sucesso");
//        } else {
//            log.error("[PréCHBK ANTI-FRAUDE] Resposta da API de chargeback vazia");
//            throw new Exception("Resposta da API de chargeback vazia");
//        }
//    }
//
//    public ResponseEntity<Object> postForAPICHBK(HttpHeaders headers, Long idCase, Long nuEc) {
//        headers.add("Content-Type", MediaType.APPLICATION_JSON.toString());
//        LocalDate data = LocalDate.now();
//        String requestApiChargeback = "{\"establishmentNumber\": [" + nuEc + "],\"startNotificationPeriod\":\"" + data + "\", \"endNotificationPeriod\":\"" + data + "\",\"idCase\": " + idCase + "}";
//        HttpEntity<String> entityApiChargeback = new HttpEntity<>(requestApiChargeback, headers);
//        return restTemplateAntiFraude.postForEntity(endpointAPIChargeback, entityApiChargeback, Object.class);
//    }
//}
