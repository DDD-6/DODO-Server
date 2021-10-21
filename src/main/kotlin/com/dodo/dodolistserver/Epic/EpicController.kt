package com.dodo.dodolistserver.Epic

import com.dodo.dodolistserver.Project.Project
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/epics")
class EpicController {

    @Autowired
    private lateinit var epicService: EpicService

    @PostMapping
    fun createEpic(@RequestBody epic: Epic): ResponseEntity<Any> {
        val createdEpic = epicService.createEpic(epic)
        return ResponseEntity.ok().body(createdEpic)
    }

    @GetMapping(path = ["/{epicId}"])
    fun getEpicByEpicId(@PathVariable("epicId") epicId: Long): ResponseEntity<Any> {
        val selectedEpic = epicService.getEpicByEpicId(epicId)
        return ResponseEntity.ok().body(selectedEpic)
    }

    @GetMapping(path = ["/project/{projectId}"])
    fun getEpicByProjectId(@PathVariable("projectId") projectId: Long): ResponseEntity<Any> {
        val projectEpics = epicService.getEpicByProjectId(projectId)
        return ResponseEntity.ok().body(projectEpics)
    }

    @PutMapping
    fun editEpic(@RequestBody epic: Epic): ResponseEntity<Any> {
        val editedEpic = epicService.editEpic(epic)
        return ResponseEntity.ok().body(editedEpic)
    }
}