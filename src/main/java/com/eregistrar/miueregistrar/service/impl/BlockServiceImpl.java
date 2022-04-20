package com.eregistrar.miueregistrar.service.impl;

import com.eregistrar.miueregistrar.model.Block;
import com.eregistrar.miueregistrar.repository.BlockRepository;
import com.eregistrar.miueregistrar.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockServiceImpl implements BlockService {
    @Autowired
    private BlockRepository blockRepository;

    @Override
    public Block saveBlock(Block block) {
        return  blockRepository.save(block);
    }

    @Override
    public List<Block> getAllBlocks() {
        return blockRepository.findAll(Sort.by("startDate"));
    }

    @Override
    public Block getBlockById(int id) {
        return blockRepository.findById(id).orElse(null);
    }
}
