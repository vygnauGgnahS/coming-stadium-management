package com.situ.stadium.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public interface Tuple<T1, T2> {
    T1 getFirst();
    T2 getSecond();

    @Getter
    @Setter
    @AllArgsConstructor
    class KV<K, V> implements Tuple<K, V> {
        private K key;
        private V value;

        public static <K, V> KV<K, V> of(K key, V value) {
            return new KV<>(key, value);
        }
        @Override
        public K getFirst() {
            return getKey();
        }

        @Override
        public V getSecond() {
            return getValue();
        }
    }
}
