package com.eregistrar.miueregistrar.service.impl;

import com.eregistrar.miueregistrar.model.Block;
import com.eregistrar.miueregistrar.repository.BlockRepository;
import com.eregistrar.miueregistrar.service.IBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * BlockServiceImpl class implements IBlockService and saves the block object to
 * mongodb using blockRepository save method.
 */
@Service
public class BlockServiceImpl implements IBlockService {
    private final BlockRepository blockRepository;

    /**
     * Instantiates a new Block service.
     *
     * @param blockRepository the block repository
     */
    @Autowired
    public BlockServiceImpl(BlockRepository blockRepository){
        this.blockRepository = blockRepository;
    }

    @Override
    public void saveBlock(Block block) {
        blockRepository.save(block);
    }

    @Override
    public List<Block> getAllBlock(){
        return blockRepository.findAll();
    }

    @Override
    public Block getBlockById(String blockId) {
        return blockRepository.findBlockById(blockId);
    }

    @Override
    public void deleteBlockById(String blockId) {
        blockRepository.deleteBlockById(blockId);
    }

    @Override
    public void updateBlock(Block block) {
        blockRepository.deleteBlockById(block.getId());
        blockRepository.save(block);
    }
}
