package com.bestbuy.fizzbuzz;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface FizzBuzzApi {
	@GET("/fizzbuzz")
	public Observable<String> getFizzBuzzMessages();
}
