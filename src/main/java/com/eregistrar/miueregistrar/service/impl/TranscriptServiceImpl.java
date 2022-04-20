package com.eregistrar.miueregistrar.service.impl;

import com.eregistrar.miueregistrar.model.Transcript;
import com.eregistrar.miueregistrar.repository.TranscriptRepository;
import com.eregistrar.miueregistrar.service.TranscriptService;
import org.springframework.stereotype.Service;

@Service
public class TranscriptServiceImpl implements TranscriptService {

    TranscriptRepository transcriptRepository;

    TranscriptServiceImpl(TranscriptRepository transcriptRepository){
        this.transcriptRepository = transcriptRepository;
    }

    @Override
    public Transcript addTranscript(Transcript transcript) {
        return transcriptRepository.save(transcript);
    }
}
