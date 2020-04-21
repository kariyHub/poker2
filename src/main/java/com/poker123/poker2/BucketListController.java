package com.poker123.poker2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BucketListController {
    @Autowired
    BucketRepository bucketRepository;

    @GetMapping(value = "/")
    public ResponseEntity index() {
        return ResponseEntity.ok(bucketRepository.findAll());
    }

    @GetMapping(value = "/bucket")
    public ResponseEntity getBucket(@RequestParam(value = "id") Long id) {
        Optional<BucketList> foundBucketList = bucketRepository.findById(id);

        if (foundBucketList.isPresent()) {
            return ResponseEntity.ok(foundBucketList.get());
        } else {
            return ResponseEntity.badRequest().body("No bucket with specified id " + id + " found");
        }
    }

    @PostMapping(value = "/")
    public ResponseEntity addToBucketList(@RequestParam(value = "id") int id,
                                          @RequestParam(value = "reg") String reg,
                                          @RequestParam(value = "time1") String time1,
                                          @RequestParam(value = "time2") String time2,
                                          @RequestParam(value = "url") String url,
                                          @RequestParam(value = "pow") int pow

    ) {
        return ResponseEntity.ok(bucketRepository.save(new BucketList(1, reg, time1, time2, url, pow)));
    }

    @PutMapping(value = "/")
    public ResponseEntity updateBucketList(@RequestParam(value = "reg") String reg,
                                           @RequestParam(value = "id") Long id,
                                           @RequestParam(value = "time1") String time1,
                                           @RequestParam(value = "time2") String time2,
                                           @RequestParam(value = "url") String url,
                                           @RequestParam(value = "pow") int pow

    ) {
        Optional<BucketList> optionalBucketList = bucketRepository.findById(id);
        if (!optionalBucketList.isPresent()) {
            return ResponseEntity.badRequest().body("No bucket with specified id " + id + " found");
        }

        BucketList foundBucketList = optionalBucketList.get();
        foundBucketList.setReg(reg);
        foundBucketList.setTime1(time1);
        foundBucketList.setTime2(time2);
        foundBucketList.setUrl(url);
        foundBucketList.setPow(pow);


        return ResponseEntity.ok(bucketRepository.save(foundBucketList));
    }

    @DeleteMapping(value = "/")
    public ResponseEntity removeBucketList(@RequestParam(value = "id") Long id) {
        bucketRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}