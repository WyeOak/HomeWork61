package lesson60.homework.Controller;

import lesson60.homework.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

import static org.apache.tomcat.util.http.fileupload.FileUploadBase.MULTIPART_FORM_DATA;


@Controller
public class MainController {
    @Autowired
    PublicationRepository publicationRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/demo")
    public String demo(Model model){
        return "index";
    }

    @RequestMapping(value = "/demo", method = RequestMethod.POST, consumes=MULTIPART_FORM_DATA)
    public final String addPost(@RequestParam("user_id") String user_id,
                                @RequestParam("description") String description,
                                @RequestParam("image") MultipartFile image) throws IOException {
        File imageFile = new File("../files/"+ image.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(imageFile);
        fos.write(image.getBytes());
        fos.close();

        User user = new User("some user", "pass123");
        user.setId(user_id);
        userRepository.save(user);

        Publication p = new Publication(user, "../files/"+ image.getOriginalFilename(), description);
        publicationRepository.save(p);

        System.out.println("done");
        return "success";
    }

    @RequestMapping(value = "/addComment", method = RequestMethod.POST)
    public final String addPost(@RequestParam("user_id") String user_id,
                                @RequestParam("post_id") String post_id,
                                @RequestParam("comment") String comment) throws IOException {
        User user = userRepository.findUserById(user_id);
        Publication publication = publicationRepository.findPublicationById(post_id);

        Comment new_comment = new Comment(user,publication,comment);
        commentRepository.save(new_comment);

        System.out.println("done");
        return "success";
    }

    @GetMapping("/files/{name}")
    @ResponseBody
    public ResponseEntity<byte[]> getImage(@PathVariable("name") String name) {
        String path = "../files";
        final MediaType mediaType = name.toLowerCase().contains(".png") ? MediaType.IMAGE_PNG : MediaType.IMAGE_JPEG;
        try {
            InputStream is = new FileInputStream(new File(path) + "/" + name);
            return ResponseEntity
                    .ok()
                    .contentType(mediaType)
                    .body(StreamUtils.copyToByteArray(is));
        } catch (Exception e) {
            InputStream is = null;
            try {
                is = new FileInputStream(new File(path) + "/" + name);
                return ResponseEntity
                        .ok()
                        .contentType(mediaType)
                        .body(StreamUtils.copyToByteArray(is));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return null;
    }
}