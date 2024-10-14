package cz.sg.testfast.controllers

import cz.sg.testfast.services.DataByIdService
import cz.sg.testfast.services.DataListService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/data")
class DataController(
    private var dataByIdService: DataByIdService,
    private var dataListService: DataListService
) {

    @GetMapping
    fun get(): List<String> {
        return dataListService.get()
    }

    @GetMapping("{id}")
    fun getById(@PathVariable("id") id: String?): String {
        return dataByIdService.get(id!!)
    }

}