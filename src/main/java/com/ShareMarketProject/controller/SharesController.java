package com.ShareMarketProject.controller;

import com.ShareMarketProject.entity.Shares;
import com.ShareMarketProject.entity.UserProfile;
import com.ShareMarketProject.service.SharesService;
import com.ShareMarketProject.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/shares")
public class SharesController {

    @Autowired
    private SharesService sharesService;

    @Autowired
    private UserService userService;

    // Endpoint to buy shares
    @PostMapping("/buy")
    public ResponseEntity<String> buyShares(@RequestParam String userName, @RequestParam int sharesId, @RequestParam int quantity) {
        Optional<UserProfile> userProfile = userService.findById(userName);
        Optional<Shares> shares = sharesService.findById(sharesId);

        if (userProfile.isPresent() && shares.isPresent()) {
            boolean success = sharesService.buyShares(userProfile.get(), shares.get(), quantity);
            if (success) {
                return ResponseEntity.ok("Shares bought successfully.");
            } else {
                return ResponseEntity.badRequest().body("Not enough shares available.");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to sell shares
    @PostMapping("/sell")
    public ResponseEntity<String> sellShares(@RequestParam String userName, @RequestParam int sharesId, @RequestParam int quantity) {
        Optional<UserProfile> userProfile = userService.findById(userName);
        Optional<Shares> shares = sharesService.findById(sharesId);

        if (userProfile.isPresent() && shares.isPresent()) {
            boolean success = sharesService.sellShares(userProfile.get(), shares.get(), quantity);
            if (success) {
                return ResponseEntity.ok("Shares sold successfully.");
            } else {
                return ResponseEntity.badRequest().body("Insufficient shares to sell.");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
