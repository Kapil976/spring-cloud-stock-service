/**
 * 
 */
package com.kapil.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kapil.model.Stock;

/**
 * @author HOME PC
 *
 */
@RestController
@RequestMapping("/stock")
public class StockController {

	@Value("${my.package.name}")
	private String name;

	@GetMapping("/data")
	public ResponseEntity<String> showStock() {
		return ResponseEntity.ok("From Stock service " + name);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Stock> getStockById(@PathVariable Long id) {
		return ResponseEntity.ok(new Stock(id, "ABC", 1200.0, 10));
	}

	@PostMapping("/create")
	public ResponseEntity<String> createStock(@RequestBody Stock stock) {
		return ResponseEntity.ok(stock.toString());
	}
}
