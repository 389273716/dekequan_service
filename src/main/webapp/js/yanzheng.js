/*!
 * 简单的表单验证
 * Author: ttm
 * Date: 2016-04-17
 */
(function( $ ) {
	
	/**
	 * 方法
	 */
	var methods = {
		
		textareaVer : function() {
			
			var isError = false;
			this.each(function() {
				
				//获取错误消息对象
				var $this = $( this ) 
				var $error = $( ".ext-" + this.id + "-error" );
				if( $this.val().trim()=='' ) {
					$error.text($error.attr( "title" ) + " 不能为空");
					isError = true;
				} else {
					$error.text("√");	
				}
				
			});
			return isError;
			
		},
		
		/**
		 * 文本输入框验证
		 */
		inputVer : function() {
			
			var isError = false;
			this.each(function() {
				
				//获取错误消息对象
				var $this = $( this ) 
				var $error = $( ".ext-" + this.id + "-error" );
				if( $this.val().trim()=='' ) {
					$error.text($error.attr( "title" ) + " 不能为空");
					isError = true;
				} else {
					$error.text("√");	
				}
				
			});
			return isError;
			
		}
		
	};
	
	$.fn.tooltip = function( method ) {
		
		if ( methods[ method ] ) {
			return methods[ method ].apply( this, Array.prototype.slice.call( arguments, 1 ));
		} else if ( !method || typeof method ) {
			//return methods( this, arguments );
		} else {
			$.error( 'Method ' + method + ' does not exist on jQuery.tooltip');	
		}
		
	};
	
})( jQuery )