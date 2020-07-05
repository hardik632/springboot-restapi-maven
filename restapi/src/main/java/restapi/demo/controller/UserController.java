
package restapi.demo.controller;

import restapi.demo.exception.ResourceNotFoundException;
import restapi.demo.model.User;
import restapi.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

  @Autowired
  private UserRepository userRepository;


  @GetMapping("/users")
  public List<User> getAllUsers()
  {
    return userRepository.findAll();
  }

  @GetMapping("/users/{id}")
  public ResponseEntity<User> getUsersById(@PathVariable(value = "id") Long userId)
      throws ResourceNotFoundException {
    User user =userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
    return ResponseEntity.ok().body(user);
  }
//
//  @PostMapping("/users")
//  public User createUser(@Valid @RequestBody User user) {
//    return userRepository.save(user);
//  }
//
//  /**
//   * Update user response entity.
//   *
//   * @param userId the user id
//   * @param userDetails the user details
//   * @return the response entity
//   * @throws ResourceNotFoundException the resource not found exception
//   */
//  @PutMapping("/users/{id}")
//  public ResponseEntity<User> updateUser(
//      @PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails)
//      throws ResourceNotFoundException {
//
//    User user =
//        userRepository
//            .findById(userId)
//            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
//
//    user.setEmail(userDetails.getEmail());
//    user.setLastName(userDetails.getLastName());
//    user.setFirstName(userDetails.getFirstName());
//    //user.setUpdatedAt(new Date());
//    final User updatedUser = userRepository.save(user);
//    return ResponseEntity.ok(updatedUser);
//  }
//
//  /**
//   * Delete user map.
//   *
//   * @param userId the user id
//   * @return the map
//   * @throws Exception the exception
//   */
//  @DeleteMapping("/user/{id}")
//  public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
//    User user =
//        userRepository
//            .findById(userId)
//            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
//
//    userRepository.delete(user);
//    Map<String, Boolean> response = new HashMap<>();
//    response.put("deleted", Boolean.TRUE);
//    return response;
//  }
}
