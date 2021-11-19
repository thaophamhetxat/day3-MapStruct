package thethao.day3mapstrucanddtos.controller;


    @RestController
    @RequestMapping("/users")
    public class UserController {

        private MapStructMapper mapstructMapper;

        private UserRepository userRepository;

        @Autowired
        public UserController(
                MapStructMapper mapstructMapper,
                UserRepository userRepository
        ) {
            this.mapstructMapper = mapstructMapper;
            this.userRepository = userRepository;
        }

        @PostMapping()
        public ResponseEntity<Void> create(
                @Valid @RequestBody UserPostDto userPostDto
        ) {
            userRepository.save(
                    mapstructMapper.userPostDtoToUser(userPostDto)
            );

            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        @GetMapping("/{id}")
        public ResponseEntity<UserGetDto> getById(
                @PathVariable(value = "id") int id
        ) {
            return new ResponseEntity<>(
                    mapstructMapper.userToUserGetDto(
                            userRepository.findById(id).get()
                    ),
                    HttpStatus.OK
            );
        }

    }
