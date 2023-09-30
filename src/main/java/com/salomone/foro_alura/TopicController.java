package com.salomone.foro_alura;


import com.salomone.foro_alura.exception.DuplicateTopicException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topics")
public class TopicController {
    private final TopicRepository topicRepository;

    @Autowired
    public TopicController(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @GetMapping
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    @GetMapping("/{id}")
    public Topic getTopicById(@PathVariable Long id) {
        return topicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("El Tópico no funciona con el id " + id));
    }

    @PostMapping
    public Topic createTopic(@RequestBody @Valid Topic topic) {
        if (topicRepository.findByTitulo(topic.getTitulo()) != null ||
                topicRepository.findByMensaje(topic.getMensaje()) != null) {
            throw new DuplicateTopicException("El título o el contenido ya existen");
        }

        return topicRepository.save(topic);
    }

    @PutMapping("/{id}")
    public Topic updateTopic(@PathVariable Long id, @RequestBody Topic updatedTopic) {
        return topicRepository.findById(id)
                .map(topic -> {
                    topic.setTitulo(updatedTopic.getTitulo());
                    topic.setMensaje(updatedTopic.getMensaje());
                    topic.setCurso(updatedTopic.getCurso());
                    return topicRepository.save(topic);
                })
                .orElseThrow(() -> new RuntimeException("Topico no funciona con el id " + id));
    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable Long id) {
        topicRepository.deleteById(id);
    }
}

