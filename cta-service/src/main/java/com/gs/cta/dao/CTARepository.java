package com.gs.cta.dao;

import com.gs.cta.entity.CallToAction;
import org.springframework.cloud.sleuth.annotation.ContinueSpan;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.cloud.sleuth.annotation.SpanTag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by schellamuthu on 12/10/18.
 */
@Repository
@Transactional
public interface CTARepository extends CrudRepository<CallToAction, Long> {
      Optional<CallToAction> findByName(String name);

      @Override
      @ContinueSpan(log = "save_to_db")
      CallToAction save(@SpanTag("cta_save_input") CallToAction s);
}
