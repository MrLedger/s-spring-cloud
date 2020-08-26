package priv.mrledger.provider.feigncall.controller;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import priv.mrledger.starter.common.dto.Person;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

@RequestMapping("/feignCall")
@RestController
public class ProviderFeignCallController {

	@PostMapping("/params")
	public String params(HttpServletRequest request, @RequestParam Person person) {
		System.out.println(person);

		HashMap<String, Object> map = Maps.newHashMap();
		map.put("params", request.getParameterMap());
		map.put("body", getBody(request));
		return new Gson().toJson(map);
	}

	@PostMapping("/body")
	public String body(HttpServletRequest request, @RequestBody Person person) {
		return params(request, person);
	}

	private String getBody(HttpServletRequest request) {
		BufferedReader br;
		String wholeStr = "";
		try {
			br = request.getReader();
			String str;
			while((str = br.readLine()) != null){
				wholeStr += str;
			}
			return wholeStr;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wholeStr;
	}

}
