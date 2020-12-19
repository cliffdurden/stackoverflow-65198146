package com.github.cliffdurden.stackoverflow65198146;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;

@Service
public class LookupService {
    public Page<LookupModel> fetchAll(Long lookupId, Pageable pageable) {

        return new Page<>() {

            private List<LookupModel> dummy = List.of(LookupModel.builder()
                    .webId(2L)
                    .build());

            @Override
            public int getTotalPages() {
                return 1;
            }

            @Override
            public long getTotalElements() {
                return dummy.size();
            }

            @Override
            public <U> Page<U> map(Function<? super LookupModel, ? extends U> converter) {
                throw new RuntimeException("not supported");
            }

            @Override
            public int getNumber() {
                return 0;
            }

            @Override
            public int getSize() {
                return dummy.size();
            }

            @Override
            public int getNumberOfElements() {
                return dummy.size();
            }

            @Override
            public List<LookupModel> getContent() {
                return dummy;
            }

            @Override
            public boolean hasContent() {
                return true;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public boolean isFirst() {
                return true;
            }

            @Override
            public boolean isLast() {
                return true;
            }

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public Pageable nextPageable() {
                return null;
            }

            @Override
            public Pageable previousPageable() {
                return null;
            }

            @Override
            public Iterator<LookupModel> iterator() {
                return dummy.iterator();
            }
        };
    }
}
