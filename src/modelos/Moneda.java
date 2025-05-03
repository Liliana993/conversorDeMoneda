package modelos;

import java.util.Map;
import java.util.Objects;

public record Moneda(Map<String, Double> conversion_rates) {}
