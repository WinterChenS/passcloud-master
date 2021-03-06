package com.paascloud.provider.service;

import com.paascloud.provider.model.dto.ProductDto;
import com.paascloud.provider.model.vo.ProductDetailVo;
import com.paascloud.provider.service.hystrix.MdcProductQueryFeignHystrix;
import com.passcloud.common.util.annotation.NoNeedAccessAuthentication;
import com.passcloud.common.util.wrapper.Wrapper;
import com.passcloud.security.feign.OAuth2FeignAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * The interface Mdc product query feign api.
 *
 * @author liyuzhang
 */
@FeignClient(value = "paascloud-provider-mdc", configuration = OAuth2FeignAutoConfiguration.class, fallback = MdcProductQueryFeignHystrix.class)
public interface MdcProductQueryFeignApi {

	/**
	 * 查询商品详情信息.
	 *
	 * @param productId the product id
	 *
	 * @return the product detail
	 */
	@PostMapping(value = "/api/product/getProductDetail/{productId}")
	@NoNeedAccessAuthentication
	Wrapper<ProductDetailVo> getProductDetail(@PathVariable("productId") Long productId);

	/**
	 * Select by id wrapper.
	 *
	 * @param productId the product id
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/api/product/selectById/{productId}")
	@NoNeedAccessAuthentication
	Wrapper<ProductDto> selectById(@PathVariable("productId") Long productId);
}
