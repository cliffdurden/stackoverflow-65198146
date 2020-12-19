package com.github.cliffdurden.stackoverflow65198146;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lookups/")
public class LookupController {

    private final LookupService lookupService;

    @Autowired
    public LookupController(LookupService lookupService) {
        this.lookupService = lookupService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Page<LookupModel>> list(@RequestParam(required = false) Long lookupId, Pageable pageable) {
        return ResponseEntity.ok(lookupService.fetchAll(lookupId,
                pageable));
    }
}