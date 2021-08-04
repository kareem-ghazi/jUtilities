package com.kimo.beginner.weathersuggestor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WeatherSuggestor {
	int temperature;
	String weatherCondition;

	public WeatherSuggestor(int temperature, String weatherCondition) {
		this.temperature = temperature;
		this.weatherCondition = weatherCondition;
	}

	public String weatherClothes() {
		String definedClothes;
		switch (weatherCondition) {
		case "R":
			definedClothes = "Take your umbrella.";
			break;
		case "SU":
			definedClothes = "Leave your umbrella.";
			break;
		case "SN":
			definedClothes = "Take your scarf and gloves.";
			break;
		default:
			definedClothes = "The input you gave for the weather was invalid.";
		}
		return definedClothes;
	}

	public String temperatureClothes() {
		String definedClothes;
		if (temperature < 20) {
			definedClothes = "Wear heavy clothes.";
		} else if (temperature < 30) {
			definedClothes = "Wear long sleeve clothes.";
		} else {
			definedClothes = "Wear light clothes.";
		}
		return definedClothes;
	}

	public static void main(String[] args) {

		try (Scanner userInput = new Scanner(System.in)) {
			System.out.println("Enter today's temperature: ");
			int definedTemperature = userInput.nextInt();

			System.out.println("(R) = Raining\n(SU) = Sunny\n(SN) = Snowy");
			System.out.println("Enter today's weather condition: ");
			String definedWeather = userInput.next().toUpperCase();

			WeatherSuggestor userOne = new WeatherSuggestor(definedTemperature, definedWeather);
			System.out.println(userOne.temperatureClothes());
			System.out.println(userOne.weatherClothes());
		} catch (InputMismatchException e) {
			System.out.println("Invalid input.");
		}
	}

}
