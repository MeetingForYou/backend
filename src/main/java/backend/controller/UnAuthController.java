package backend.controller;

import backend.interceptor.JwtService;
import backend.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/unauthorized")
public class UnAuthController {

    @Autowired
    private JwtService jwtService;

    @GetMapping("/refesh-token")
    public ResponseEntity<ResultEntity<Object>> getRefreshToken(@RequestParam("id") Integer id){

        return ResultEntity.success(
                200,
                "Refresh token successfully",
                jwtService.generateToken(id)
        );
    }
}
