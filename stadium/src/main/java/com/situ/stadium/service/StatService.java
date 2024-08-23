package com.situ.stadium.service;

import com.situ.stadium.util.Tuple;

import java.util.List;

public interface StatService {
    List<Tuple.KV<String, Long>> statOfSportsTypeOfOrders();

    List<Tuple.KV<String, Long>> statOfCoachOfOrders();

}
