package farishollow.com.journal.controller;


import farishollow.com.journal.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();


    @GetMapping
    public List<JournalEntry> getAll(){

        return new ArrayList<>(journalEntries.values());


    }


    @PostMapping
    public String createEntry(@RequestBody JournalEntry myEntry){

        journalEntries.put(myEntry.getId(), myEntry);
        return "Entry posted successfully";
    }

    @GetMapping("Id/{myId}")
    public JournalEntry getJournalById(@PathVariable Long myId){

        return journalEntries.get(myId);

    }

    @DeleteMapping("Id/{myId}")
    public JournalEntry deleteJournalById(@PathVariable Long myId){

        return journalEntries.remove(myId);

    }

    @PutMapping("Id/{myId}")
    public JournalEntry editJournalById(@PathVariable Long myId, @RequestBody JournalEntry myEntry){

        return journalEntries.put(myId, myEntry);

    }
}
